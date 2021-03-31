package com.reservationEnligne.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservationEnligne.dao.StudentDAO;
import com.reservationEnligne.model.Calendrier;
import com.reservationEnligne.model.Student;
import com.reservationEnligne.service.StudentService;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDAO studentDAO;
	
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	
	public StudentDAO getStudentDAO() {
		return studentDAO;
	}
	
	@Override
	public boolean registerStudent(Student student) {
		boolean isRegister=false;
		boolean saveStudent = getStudentDAO().saveStudent(student);
		if(saveStudent)
			isRegister=true;
		return isRegister;
	}

	@Override
	public List<Student> getListStudent() {
		List<Student> student = getStudentDAO().getListStudent();
		return student;
	}
	
	
	@Override
	public List<Student> getListStudentValidation() {
		List<Student> student = getStudentDAO().getListStudentValidation();
		return student;
	}
	@Override
	public void updateValider(int id) {
		getStudentDAO().updateValider(id);
	
	}
}

