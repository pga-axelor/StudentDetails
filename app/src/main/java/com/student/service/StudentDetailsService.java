package com.student.service;

import java.io.IOException;
import java.util.ArrayList;

import com.student.db.StudentDetails;

public interface StudentDetailsService {

	public void insert(StudentDetails s);

	public ArrayList<StudentDetails> fetchData(Integer id);

	public void update(StudentDetails s);

	public void delete(Integer usn) throws IOException;

	public ArrayList<StudentDetails> show();

	public ArrayList<StudentDetails> search(String search,String order);
}
