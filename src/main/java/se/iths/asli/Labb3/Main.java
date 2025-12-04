package se.iths.asli.Labb3;

public class Main {
    public static void main(String[] args) {
        PersonDAO dao = new PersonDAOImpl();

        Person newPerson = new Person(
                "Boromir",
                "Gondor",
                java.sql.Date.valueOf("1950-05-05"),
                30000.0);

        System.out.println("Hämtar alla personer");
        for (Person p : dao.findAll()) {
            System.out.println(
                    p.getPersonId() + " " +
                            p.getFirstName() + " " +
                            p.getLastName() + " " +
                            p.getDob() + " " +
                            p.getIncome()
            );
        }
    }
}
