package com.reservationEnligne.dao;

import java.util.*;

import com.reservationEnligne.model.Student;

public interface StudentDAO {
	public abstract boolean saveStudent(Student student);
	public List<Student> getListStudent();
	public void updateValider(int id);
	List<Student> getListStudentValidation();

}
