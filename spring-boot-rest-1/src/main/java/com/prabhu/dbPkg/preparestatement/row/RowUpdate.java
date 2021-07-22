package com.prabhu.dbPkg.preparestatement.row;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RowUpdate {

    private static final String SQL_UPDATE = "UPDATE EMPLOYEE2 SET SALARY=? WHERE NAME=?";

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(
        		"jdbc:oracle:thin:@devmdxdb01:1522:DMMENDIX12D", "MONTAJI_DEV", "MONTAJI_DEV");
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPDATE)) {

            preparedStatement.setBigDecimal(1, new BigDecimal(999.99));
            preparedStatement.setString(2, "mkyong");

            int row = preparedStatement.executeUpdate();

            // rows affected
            System.out.println(row);

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
