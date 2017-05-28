package pl.edu.pjatk.zad10_dbunit.service;

// w oparciu o przyklad J Neumanna, przerobiony przez T Puzniakowskiego

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import pl.edu.pjatk.zad10_dbunit.domain.DataObject;
import pl.edu.pjatk.zad10_dbunit.domain.Person;

public interface PersonManager {
	public Connection getConnection();
	public int addPerson(Person person);
	public List<Person> getAllPersons();
	public Person getPersonByName(String name);
	public int updatePerson(Person person);
	public List<Person> getPersonByDataObjectId(long id);
}
