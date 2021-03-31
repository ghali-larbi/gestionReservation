package com.reservationEnligne.dao;

import java.util.List;

import com.reservationEnligne.model.Calendrier;
import com.reservationEnligne.model.reservation;

public interface CalendrierDao {
	

	int createReservation(Calendrier calendrier);

	List<Calendrier> getListCalendrier();
	int makeCalendrier(String reservationDate, String reservationTime, int seatsNumber,String valid, int id);
	List<reservation> getListReservation();
	public void updateReservation(int id);
	public void nombrePlace(int id);
	List<reservation> getListReservationValidation();

}
