package pl.edu.pjatk.zad10_dbunit.service;

// w oparciu o przyklad J Neumanna, przerobiony przez T Puzniakowskiego

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import pl.edu.pjatk.zad10_dbunit.domain.DataObject;
import pl.edu.pjatk.zad10_dbunit.domain.Person;

public interface DataManager {
	public Connection getConnection();
	public int addData(DataObject data);
	public List<DataObject> getAllData();
	public int updateData(DataObject data);
	public int deleteData(int id);
}
