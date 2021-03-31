package com.reservationEnligne.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.reservationEnligne.model.Calendrier;
import com.reservationEnligne.model.Student;
import com.reservationEnligne.model.reservation;
import com.reservationEnligne.service.CalendrierService;
import com.reservationEnligne.service.StudentService;

@Controller
public class ControllerCalendrier {
	@Autowired
	private CalendrierService calendrierService;

	public void setCalendrierService(CalendrierService calendrierService) {
		this.calendrierService = calendrierService;
	}
	public CalendrierService getCalendrierService() {
		return calendrierService;
	}
	@RequestMapping(value ="/calendrier" ,method=RequestMethod.GET)
	public String CalendrierPage(HttpSession session){
		if(session.getAttribute("role")==null) {
			return "/login";	
			}
		return "calendrier";
	}
	@RequestMapping(value ="ajouterCalendrier" ,method=RequestMethod.POST)
	public ModelAndView ajouterCalendrier(Calendrier calendrier ){
	int affectedRow = calendrierService.saveCalendrier(calendrier);
	return new ModelAndView("calendrier");
	}
	@RequestMapping(value ="/reserver",method=RequestMethod.GET)
	public ModelAndView listCalendrier(HttpServletRequest request)
	{
		List<Calendrier>calendrier= getCalendrierService().getListCalendrier();
		System.out.println("size: "+calendrier.size());
		if(calendrier.size()>0) {
			request.setAttribute("Calendrier", calendrier);
		}
		return new ModelAndView("reserver");
   }
	@RequestMapping(value ="/reservation" ,method=RequestMethod.POST)
	public ModelAndView makeCalendrier(reservation resrv, HttpServletRequest request,@RequestParam String dateCalendrier,@RequestParam String heureCalendrier,@RequestParam int nombrePlace)
	{
		resrv.setDateCalendrier(dateCalendrier);
		resrv.setHeureCalendrier(heureCalendrier);
		resrv.setNombrePlace(nombrePlace);
		resrv.setValidation("noValid");
		System.out.println(resrv.getDateCalendrier());
		HttpSession session= request.getSession();
		int id=Integer.parseInt(session.getAttribute("id").toString());
		int affectedRow = getCalendrierService().makeCalendrier(resrv,id);
		 return new ModelAndView("reserver");
	}
	
	@RequestMapping(value ="/listReservation" ,method=RequestMethod.GET)
	public ModelAndView listReservation(HttpServletRequest request)
	{
		List<reservation>listReservation= getCalendrierService().getListReservationValidation();
		request.setAttribute("listReservation", listReservation);
		return new ModelAndView("listReservation");
   }
	@RequestMapping(value ="/validerReservation/{id}" ,method=RequestMethod.GET)
	public ModelAndView updateValidation(HttpServletRequest request,@PathVariable int id){
		getCalendrierService().updateReservation(id);
		getCalendrierService().nombrePlace(id);
		List<reservation>listReservation= getCalendrierService().getListReservationValidation();
		request.setAttribute("listReservation", listReservation);
		return new ModelAndView("listReservation");
	}
}
