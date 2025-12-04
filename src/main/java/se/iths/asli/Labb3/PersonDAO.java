package se.iths.asli.Labb3;

import java.util.List;

public interface PersonDAO {
    void insert(Person person);

    List<Person> findAll();
}
