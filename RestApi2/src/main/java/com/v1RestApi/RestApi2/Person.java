package com.v1RestApi.RestApi2;

public class Person {
	private int id;
	private String fName;
	private String lName;
	
	public Person() {}
	public Person(int id, String fName, String lName) {
		this.id = id;
		this.fName = fName;
		this.lName = lName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", fName=" + fName + ", lName=" + lName + "]";
	}
	
	
	

}
