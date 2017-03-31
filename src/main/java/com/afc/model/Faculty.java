package com.afc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name = "faculty")
public class Faculty {
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private long facultyid;
	 
	 @Column(name = "name")
	 private String name;
	 
	 @DateTimeFormat(pattern="dd/MM/yyyy")
	 @Column(name = "established_date")
	 private Date established_date;
	 
	 public Faculty() {
		 
	 }
	 
	 
	 
	 public Faculty(String name, Date established_date) {
	      this.name = name;
	      this.established_date = established_date;
	 }
	
	 @DateTimeFormat(pattern="dd/MM/yyyy")
	 public Date getEstablished_date() {
		return established_date;
	}
	 public void setEstablished_date(Date established_date) {
		this.established_date = established_date;
	}
	 
	 public String getName() {
			
			return this.name;
	 }
	 public void setName(String name) {
		this.name = name;
	}
	 
	 public void setFacultyid(long id) {
	      this.facultyid = id;
	 }
	 public long getFacultyid() {
			return facultyid;
		}
	 
	 
	 @Override
	 public String toString() {
		 return String.format("<td align='center'>%d</td><td align='center'>%s</td><td align='center'>%s</td>", facultyid,name,established_date);
     }


	
}
