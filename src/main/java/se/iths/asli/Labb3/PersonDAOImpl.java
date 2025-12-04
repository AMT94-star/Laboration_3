package se.iths.asli.Labb3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDAOImpl implements PersonDAO {
    @Override
    public void insert(Person person) {
        String sqlInsert = "INSERT INTO person (first_name, last_name, dob, income) VALUES (?, ?, ?, ?)";

        try (Connection conn = Settings.getInstance().getConnection()) {
            System.out.println("Ansluten till databasen");

            PreparedStatement insertStmt = conn.prepareStatement(sqlInsert);
            insertStmt.setString(1, person.getFirstName());
            insertStmt.setString(2, person.getLastName());
            insertStmt.setDate(3, person.getDob());
            insertStmt.setDouble(4, person.getIncome());

            insertStmt.executeUpdate();
            System.out.println("Person insatt");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Person> findAll() {
        List<Person> personList = new ArrayList<>();
        String sqlSelect = "SELECT * FROM person";

        try (Connection conn = Settings.getInstance().getConnection()) {
            PreparedStatement selectStmt = conn.prepareStatement(sqlSelect);
            ResultSet rs = selectStmt.executeQuery();
            System.out.println("Här är alla personer i databasen");

            while (rs.next()) {
                Person person = new Person(
                        rs.getInt("person_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getDate("dob"),
                        rs.getDouble("income"));
                personList.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personList;
    }
}
