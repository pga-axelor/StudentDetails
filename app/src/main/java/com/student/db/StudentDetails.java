package com.student.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StudentDetails {

	@Id
	@Column(name = "usn")
	private int usn;
	@Column(name = "name")
	private String sname;
	@Column(name = "semester")
	private int sem;
	@Column(name = "year")
	private int year;
	@Column(name = "branch")
	private String branch;

	public int getUsn() {
		return usn;
	}

	public void setUsn(int usn) {
		this.usn = usn;
	}

	public StudentDetails() {

	}

	public StudentDetails(int usn, String sname, int sem, int year, String branch) {
		super();
		this.usn = usn;
		this.sname = sname;
		this.sem = sem;
		this.year = year;
		this.branch = branch;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getSem() {
		return sem;
	}

	public void setSem(int sem) {
		this.sem = sem;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	@Override
	public String toString() {
		return "student_details [usn=" + usn + ", sname=" + sname + ", sem=" + sem + ", year=" + year + ", branch="
				+ branch + "]";
	}

}