package com.infotech.service;

import java.util.List;

import com.infotech.model.Calendrier;
import com.infotech.model.Student;

public interface CalendrierService {
	int saveCalendrier(Calendrier calendrier);

	List<Calendrier> getListCalendrier();

	int makeCalendrier(Calendrier calendrier, int id);
}
