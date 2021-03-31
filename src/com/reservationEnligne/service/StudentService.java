package com.reservationEnligne.service;

import java.util.*;

import com.reservationEnligne.model.Calendrier;
import com.reservationEnligne.model.Student;

public interface StudentService {
	public abstract List<Student> getListStudent();
	public abstract boolean registerStudent(Student student);
	void updateValider(int id);
	List<Student> getListStudentValidation();


}