package com.prabhu.dbPkg.callablestatement;

import oracle.jdbc.OracleTypes;

import java.math.BigDecimal;
import java.sql.*;

import com.prabhu.beans.Employee2;

/*
    CREATE OR REPLACE PROCEDURE get_employee_by_name(
	   p_name IN EMPLOYEE.NAME%TYPE,
	   o_c_dbuser OUT SYS_REFCURSOR)
    AS
    BEGIN
      OPEN o_c_dbuser FOR
      SELECT * FROM EMPLOYEE WHERE NAME LIKE p_name || '%';
    END;
 */
public class StoreProcedureCursor {

    public static void main(String[] args) {

        String createSP = "CREATE OR REPLACE PROCEDURE get_employee_by_name( "
                + " p_name IN EMPLOYEE3.NAME%TYPE, "
                + " o_c_dbuser OUT SYS_REFCURSOR) "
                + " AS "
                + " BEGIN "
                + "     OPEN o_c_dbuser FOR "
                + "     SELECT * FROM EMPLOYEE3 WHERE NAME LIKE p_name || '%'; "
                + " END; ";

        String runSP = "{ call get_employee_by_name(?,?) }";

        try (Connection conn = DriverManager.getConnection(
        		"jdbc:oracle:thin:@devmdxdb01:1522:DMMENDIX12D", "MONTAJI_DEV", "MONTAJI_DEV");
             Statement statement = conn.createStatement();
             CallableStatement cs = conn.prepareCall(runSP);
        ) {

            //conn.setAutoCommit(false);

            // create function
            statement.execute(createSP);

            cs.setString(1, "mk");

            // alternative
            //cs.registerOutParameter(2, Types.REF_CURSOR);
            cs.registerOutParameter(2, OracleTypes.CURSOR);

            // run SP
            cs.execute();

            // get refcursor and convert it to ResultSet
            ResultSet resultSet = (ResultSet) cs.getObject(2);
            while (resultSet.next()) {

                long id = resultSet.getLong("ID");
                String name = resultSet.getString("NAME");
                BigDecimal salary = resultSet.getBigDecimal("SALARY");
                Timestamp createdDate = resultSet.getTimestamp("CREATED_DATE");

                Employee2 obj = new Employee2();
                obj.setId(id);
                obj.setName(name);
                obj.setSalary(salary);
                // Timestamp -> LocalDateTime
                obj.setCreatedDate(createdDate.toLocalDateTime());

                System.out.println(obj);

            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
