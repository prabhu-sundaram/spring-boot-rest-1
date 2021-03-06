package com.prabhu.dbPkg.statement.row;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class RowUpdate {

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(
        		"jdbc:oracle:thin:@devmdxdb01:1522:DMMENDIX12D", "MONTAJI_DEV", "MONTAJI_DEV");
             Statement statement = conn.createStatement()) {

            int row = statement.executeUpdate(updateSalaryByName("mkyong", new BigDecimal(1080)));

            // rows affected
            System.out.println(row);


        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static String updateSalaryByName(String name, BigDecimal salary) {

        return "UPDATE EMPLOYEE3 SET SALARY='" + salary + "' WHERE NAME='" + name + "'";

    }
}