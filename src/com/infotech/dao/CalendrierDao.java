package com.infotech.dao;

import java.util.List;

import com.infotech.model.Calendrier;

public interface CalendrierDao {
	

	int createReservation(Calendrier calendrier);

	List<Calendrier> getListCalendrier();
	int makeCalendrier(String reservationDate, String reservationTime, int seatsNumber, int id);

}
