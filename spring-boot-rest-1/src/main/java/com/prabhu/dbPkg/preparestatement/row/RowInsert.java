package com.prabhu.dbPkg.preparestatement.row;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;

public class RowInsert {

    private static final String SQL_INSERT = "INSERT INTO EMPLOYEE2 (NAME, SALARY, CREATED_DATE) VALUES (?,?,?)";

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(
        		"jdbc:oracle:thin:@devmdxdb01:1522:DMMENDIX12D", "MONTAJI_DEV", "MONTAJI_DEV");
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT)) {

            preparedStatement.setString(1, "mkyong");
            preparedStatement.setBigDecimal(2, new BigDecimal(699.88));
            //preparedStatement.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

            preparedStatement.setObject(3, LocalDateTime.now());

            // ZonedDateTime to TimeStamp
            //preparedStatement.setTimestamp(3, Timestamp.from(ZonedDateTime.now().toInstant()));

            int row = preparedStatement.executeUpdate();

            // rows affected
            System.out.println(row); // 1

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}