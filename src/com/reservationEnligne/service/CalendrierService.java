package com.reservationEnligne.service;

import java.util.List;

import com.reservationEnligne.model.Calendrier;
import com.reservationEnligne.model.Student;
import com.reservationEnligne.model.reservation;

public interface CalendrierService {
	int saveCalendrier(Calendrier calendrier);

	List<Calendrier> getListCalendrier();
	List<reservation> getListReservation();
	int makeCalendrier(reservation resv, int id);
	void updateReservation(int id);
	void nombrePlace(int id);
	List<reservation> getListReservationValidation();
}
