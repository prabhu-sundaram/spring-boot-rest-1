package com.prabhu.dbPkg.preparestatement.table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TableDrop {

    private static final String SQL_DROP = "DROP TABLE EMPLOYEE2";

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(
        		"jdbc:oracle:thin:@devmdxdb01:1522:DMMENDIX12D", "MONTAJI_DEV", "MONTAJI_DEV");
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_DROP)) {

            preparedStatement.execute();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}