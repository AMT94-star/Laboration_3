package se.iths.asli.Labb3;

public class Person {
    private Integer id;
    private String firstName;
    private String lastName;
    private java.sql.Date dob;
    private double income;

    //Konstruktor för att hämta data från databasen
    public Person(Integer id, String firstName, String lastName, java.sql.Date dob, double income) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.income = income;
    }

    //Konstruktor för att skapa ny data
    public Person(String firstName, String lastName, java.sql.Date dob, double income) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.income = income;
    }

    public Integer getPersonId() {
        return id;
    }

    public void setPersonId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public java.sql.Date getDob() {
        return dob;
    }

    public void setDob(java.sql.Date dob) {
        this.dob = dob;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

}
