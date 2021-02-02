package com.cg.healthyfy.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.*;

@Entity
@Data
public class CustomerInfo {
	
@Id	
@GeneratedValue(strategy = GenerationType.IDENTITY)
int id;
private String name; 
private String gender;
private String dob;
private String contact;
private String medicalCondition;
private String allergicTo;

public CustomerInfo(String name,String gender,String dob,String contact,String medicalCondition,String allergicTo) {
	super();
	this.name=name;
	this.gender=gender;
	this.dob=dob;
	this.contact=contact;
	this.medicalCondition=medicalCondition;
	this.allergicTo=allergicTo;
}

public CustomerInfo() {
	// TODO Auto-generated constructor stub
}



}