package se.iths.asli.Labb3;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/labb_2";
        String user = "root";
        String password = "P1kachu2023!";
        String sqlInsert = "INSERT INTO person (first_name, last_name, dob, income) VALUES (?, ?, ?, ?)";
        String sqlSelect = "SELECT * FROM person";
        String sqlDelete = "DELETE FROM person WHERE person_id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Ansluten till databasen");

            PreparedStatement insertStmt = conn.prepareStatement(sqlInsert);
            insertStmt.setString(1, "Cecilia");
            insertStmt.setString(2, "Corall");
            insertStmt.setDate(3, java.sql.Date.valueOf("2002-02-02"));
            insertStmt.setInt(4, 38000);

            int insertedRows = insertStmt.executeUpdate();
            System.out.println("Rader insatta: " + insertedRows);

            //delete för dublett
//            PreparedStatement preparedStatement = conn.prepareStatement(sqlDelete);
//            preparedStatement.setInt(1, 7);
//
//            int deletedRows = preparedStatement.executeUpdate();
//            System.out.println(deletedRows);

            PreparedStatement selectStmt = conn.prepareStatement(sqlSelect);
            ResultSet rs = selectStmt.executeQuery();
            System.out.println("Här är alla personer i databasen");
            while (rs.next()) {
                int person_id = rs.getInt("person_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                Date dob = rs.getDate("dob");
                double income = rs.getDouble("income");

                System.out.println(person_id + " " + firstName + " " + lastName +
                        " " + " " + dob + " " + income);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
