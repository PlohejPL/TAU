package pl.edu.pjatk.zad10_dbunit.domain;

public class Person {
	
	private long id;
	
	private String name;
	private int yob;
	private long dataObject_id;
	
	public Person() {
	}
//
//	public Person(String name, int yob) {
//		super();
//		this.name = name;
//		this.yob = yob;
//	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYob() {
		return yob;
	}
	public void setYob(int yob) {
		this.yob = yob;
	}
	public long getDataObject_id() {
		return dataObject_id;
	}
	public void setDataObject_id(long dataObject_id) {
		this.dataObject_id = dataObject_id;
	}
	
}
