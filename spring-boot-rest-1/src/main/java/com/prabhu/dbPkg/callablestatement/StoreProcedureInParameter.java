package com.prabhu.dbPkg.callablestatement;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;

/*
    CREATE OR REPLACE PROCEDURE insert_employee(
	   p_name IN EMPLOYEE.NAME%TYPE,
	   p_salary IN EMPLOYEE.SALARY%TYPE,
	   p_date IN EMPLOYEE.CREATED_DATE%TYPE)
    AS
    BEGIN
      INSERT INTO EMPLOYEE ("NAME", "SALARY", "CREATED_DATE") VALUES (p_name, p_salary, p_date);
      COMMIT;
    END;
 */
public class StoreProcedureInParameter {

    public static void main(String[] args) {

        String createSP = "CREATE OR REPLACE PROCEDURE insert_employee( "
                + " p_name IN EMPLOYEE3.NAME%TYPE, "
                + " p_salary IN EMPLOYEE3.SALARY%TYPE, "
                + " p_date IN EMPLOYEE3.CREATED_DATE%TYPE) "
                + " AS "
                + " BEGIN "
                + "     INSERT INTO EMPLOYEE3 (\"NAME\", \"SALARY\", \"CREATED_DATE\") VALUES (p_name, p_salary, p_date); "
                + "     COMMIT; "
                + " END; ";

        String runSP = "{ call insert_employee(?,?,?) }";

        try (Connection conn = DriverManager.getConnection(
        		"jdbc:oracle:thin:@devmdxdb01:1522:DMMENDIX12D", "MONTAJI_DEV", "MONTAJI_DEV");
             Statement statement = conn.createStatement();
             CallableStatement callableStatement = conn.prepareCall(runSP)) {

            // create or replace stored procedure
            statement.execute(createSP);

            //----------------------------------

            callableStatement.setString(1, "mkyong");
            callableStatement.setBigDecimal(2, new BigDecimal("99.99"));
            callableStatement.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

            // Run insertEmployee() SP
            callableStatement.executeUpdate();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}