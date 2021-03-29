package com.infotech.dao;

import java.util.ArrayList;

import com.infotech.model.Student;

import java.util.*;

public interface StudentDAO {
	public abstract boolean saveStudent(Student student);
	public List<Student> getListStudent();
	public void updateValider(Student student);

}
