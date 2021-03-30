package com.infotech.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.infotech.model.Calendrier;
import com.infotech.model.Student;
import com.infotech.service.CalendrierService;
import com.infotech.service.StudentService;

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
	public String CalendrierPage(){
		return "calendrier";
	}
	@RequestMapping(value ="ajouterCalendrier" ,method=RequestMethod.POST)
	public ModelAndView ajouterCalendrier(Calendrier calendrier ){
	int affectedRow = calendrierService.saveCalendrier(calendrier);
	return new ModelAndView("calendrier");
	}
	@RequestMapping(value ="/reserver" ,method=RequestMethod.GET)
	public ModelAndView listCalendrier(HttpServletRequest request)
	{
		List<Calendrier>calendrier= getCalendrierService().getListCalendrier();
		System.out.println("size: "+calendrier.size());
		request.setAttribute("Calendrier", calendrier);
		return new ModelAndView("reserver");
   }
	@RequestMapping(value ="/reservation" ,method=RequestMethod.POST)
	public ModelAndView makeCalendrier(Calendrier calendrier, HttpServletRequest request,@RequestParam String dateCalendrier,@RequestParam String heureCalendrier,@RequestParam int nombrePlace)
	{
		calendrier.setDateCalendrier(dateCalendrier);
		calendrier.setHeureCalendrier(heureCalendrier);
		calendrier.setNombrePlace(nombrePlace);
		System.out.println(calendrier.getDateCalendrier());
		
		HttpSession session= request.getSession();
		int id=Integer.parseInt(session.getAttribute("id").toString());
        
		int affectedRow = getCalendrierService().makeCalendrier(calendrier,id);
		 return new ModelAndView("reserver");
	}
	
}
