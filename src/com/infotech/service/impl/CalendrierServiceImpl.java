package com.infotech.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infotech.dao.CalendrierDao;
import com.infotech.dao.StudentDAO;
import com.infotech.model.Calendrier;
import com.infotech.model.Student;
import com.infotech.service.CalendrierService;

@Service("CalendrierService")
public class CalendrierServiceImpl implements CalendrierService {
	@Autowired
	private CalendrierDao calendrierDao;
	
	public void setCalendrierDAO(CalendrierDao calendrierDao) {
		this.calendrierDao = calendrierDao;
	}
	
	public CalendrierDao getCalendrierDAO() {
		return calendrierDao;
	}

	@Override
	public int saveCalendrier(Calendrier calendrier) {
		int affectedRow = calendrierDao.createReservation(calendrier);
		return affectedRow;
	}
	
	@Override
	public List<Calendrier> getListCalendrier() {
		List<Calendrier> calendrier = getCalendrierDAO().getListCalendrier();
		return calendrier;
	}
	@Override
	public int makeCalendrier(Calendrier calendrier, int id) {
		String reservationDate;
		String reservationTime;
		int seatsNumber;
		reservationDate = calendrier.getDateCalendrier();
		reservationTime = calendrier.getHeureCalendrier();
		seatsNumber = calendrier.getNombrePlace();
		System.out.println(reservationDate+"/"+reservationTime+"/"+id);
		int affectedRow = getCalendrierDAO().makeCalendrier(reservationDate, reservationTime, seatsNumber, id);
		return affectedRow;
	}
}

