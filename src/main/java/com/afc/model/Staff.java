package com.afc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.afc.model.Faculty;
@Entity
@Table(name = "staff")
public class Staff {
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private long staffid;
	 
	 @Column(name = "name")
	 private String name;
	 
	 @Column(name = "address")
	 private String address;
	 
	 @Column(name = "position")
	 private String position;
	 
	 
	 @ManyToOne(optional=false)
	 @JoinColumn(name = "facultyid", referencedColumnName = "facultyid")
	 private Faculty faculty;
	 public Staff() {
	 }
	 
	 public Staff(String name, String address, String position, Faculty faculty) {
	     this.name = name;
	     this.address = address;
	     this.position = position;
	     this.faculty = faculty;
	 }
	 
	 @Override
	 public String toString() {
	     return String.format("<td align='center'>%d</td><td align='center'>%s</td><td align='center'>%s</td><td align='center'>%s</td><td align='center'>%s</td>", staffid, name, address, position,faculty.getName());
     }
	 public Faculty getFaculty() {
	      return faculty;
	 }
	  public void setFaculty(Faculty faculty) {
	     this.faculty = faculty;
	  }
	  
	public long getStaffid() {
		return staffid;
	}
	 public void setStaffid(long staffid) {
		this.staffid = staffid;
	}
	 
	 public void setAddress(String address) {
		this.address = address;
	}
	 public String getAddress() {
		return address;
	}
	 
	 public void setName(String name) {
		this.name = name;
	}
	 public String getName() {
		return name;
	}
	 
	 public void setPosition(String position) {
		this.position = position;
	}
	 public String getPosition() {
		return position;
	}

}
