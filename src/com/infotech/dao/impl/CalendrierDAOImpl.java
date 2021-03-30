package com.infotech.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.infotech.dao.CalendrierDao;
import com.infotech.model.Calendrier;
import com.infotech.model.Student;
import com.infotech.model.reservation;

@Repository("CalendrierDao")
public class CalendrierDAOImpl implements CalendrierDao {
	@Autowired
	private SessionFactory sessionFactory;

	private Session session = null;
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Override
	public int createReservation(Calendrier calendrier) {
		
		String reservationDate = calendrier.getDateCalendrier();
		String reservationTime = calendrier.getHeureCalendrier();
		Integer seatsNumber = calendrier.getNombrePlace();

		Calendrier d = new Calendrier(reservationDate, reservationTime, seatsNumber);

		session = sessionFactory.openSession();
		session.beginTransaction();

		int affectedRows = (int) session.save(d);

		session.getTransaction().commit();

		return affectedRows;
}
	@SuppressWarnings("unchecked")
	@Override
	public List<Calendrier> getListCalendrier(){
		 Transaction transaction = null;
		 List<Calendrier>  listCalendrier =null;
			Session session = hibernateTemplate.getSessionFactory().openSession();
			// start a transaction
			transaction = session.beginTransaction();
			listCalendrier =   session.createQuery("from Calendrier ").list();
			return listCalendrier;
			
	}
	public int makeCalendrier(String reservationDate, String reservationTime, int seatsNumber, int id) {
		Student u = new Student();
		u.setId(id);

		reservation a = new reservation();
		a.setDateCalendrier(reservationDate);
		a.setHeureCalendrier(reservationTime);
		a.setNombrePlace(seatsNumber);
		a.setStudent_table(u);
		session = sessionFactory.openSession();
		session.beginTransaction();
		int affectedRows = (int) session.save(a);
		session.getTransaction().commit();
		return affectedRows;
	}
}
