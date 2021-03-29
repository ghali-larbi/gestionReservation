package com.infotech.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import com.infotech.dao.StudentDAO;
import com.infotech.model.Student;

@Repository("studentDAO")
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Override
	public boolean saveStudent(Student student) {
		int id = (Integer)hibernateTemplate.save(student);
		if(id>0)
			return true;
		return false;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getListStudent(){
		 Transaction transaction = null;
		 List<Student>  listUser =null;
			Session session = hibernateTemplate.getSessionFactory().openSession();
			// start a transaction
			transaction = session.beginTransaction();
			listUser =   session.createQuery("from Student where validation='noValid'").list();
			return listUser;
			
	}
	

	@Override
	public void updateValider(Student student) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		// start a transaction
		Transaction transaction = session.beginTransaction();
		session.update(student);
		// commit transaction
		transaction.commit();
	     
	
	}
}
