package com.prabhu.dbPkg.statement.table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TableDrop {

    public static void main(String[] args) {

        // Oracle don't have this
        // String SQL_DROP = "DROP TABLE IF EXISTS EMPLOYEE";

        String SQL_DROP = "DROP TABLE EMPLOYEE3";

        try (Connection conn = DriverManager.getConnection(
        		"jdbc:oracle:thin:@devmdxdb01:1522:DMMENDIX12D", "MONTAJI_DEV", "MONTAJI_DEV");
             Statement statement = conn.createStatement()) {

            // if DDL failed, it will raise an SQLException
            statement.execute(SQL_DROP);

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
