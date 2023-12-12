package com.spring.orm.springorm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "student")
public class Student {
	
@Id
private int id;
@Column(name = "name")
private String name;
@Column(name = "address")
private String address;

public Student() {}

public Student(int id, String name, String city) {
	super();
	this.id = id;
	this.name = name;
	this.address = city;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	name = name;
}

public String getCity() {
	return address;
}

public void setCity(String city) {
	this.address = city;
}

@Override
public String toString() {
	return "Student [id=" + id + ", Name=" + name + ", city=" + address + "]";
}







}
