package com.infotech.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.infotech.dao.impl.StudentDAOImpl;
import com.infotech.model.Student;
import com.infotech.model.StudentCredential;
import com.infotech.service.StudentService;

@Controller
public class MyController {
	
	@Autowired
	private StudentService studentService;

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
	public StudentService getStudentService() {
		return studentService;
	}
	
	@RequestMapping(value ="/" ,method=RequestMethod.GET)
	public String homePage(){
		return "login";
	}
	@RequestMapping(value ="/welcome" ,method=RequestMethod.GET)
	public String WelcomePage(){
		return "welcome";
	}
	
	@RequestMapping(value ="/login" ,method=RequestMethod.GET)
	public String loginPage(Model model){
		model.addAttribute("studentCredential", new StudentCredential());
		return "login";
	}

	@RequestMapping(value ="/register" ,method=RequestMethod.GET)
	public String registerPage(Model model){
		model.addAttribute("student", new Student());
		return "register";
	}
	@RequestMapping(value ="/logout" ,method=RequestMethod.GET)
	public ModelAndView LogoutPage(Model model,HttpServletRequest request){
		request.getSession().invalidate();
	   return new ModelAndView("login");
	}
	
	@RequestMapping(value ="/registerSuccess" ,method=RequestMethod.POST)
	public ModelAndView registerSuccess(@Valid @ModelAttribute("student") Student student,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return new ModelAndView("register");
		}
		//System.out.println(student.getEmail()+"/"+student.getFirstName()+"/n"+student.getLastName()+"/n"+student.getPassword()+"/n"+student.getPhone()+"/n"+student.getRole()+"/n");
        getStudentService().registerStudent(student);
		return new  ModelAndView("register");
	}
	@RequestMapping(value ="/loginSuccess" ,method=RequestMethod.POST)
	public ModelAndView loginSuccess(@RequestParam("email") String email,@RequestParam("password") String password,HttpServletRequest request,HttpServletRequest response){
		List<Student>listUtilisateur= getStudentService().getListStudent();
		 System.out.println("email"+email+"password"+password);
		String path="";
		 for (int i = 0; i < listUtilisateur.size(); i++){
             if(listUtilisateur.get(i).getRole().equals("apprenant") && listUtilisateur.get(i).getValidation().equals("Valid")){
            	 System.out.println("thats true !!!");
                 if(listUtilisateur.get(i).getEmail().equals(email) && listUtilisateur.get(i).getPassword().equals(password) ){
                   HttpSession client= request.getSession();
                 client.setAttribute("role",listUtilisateur.get(i).getRole());
                 client.setAttribute("nom",listUtilisateur.get(i).getLastName());
                 path="welcome";
                 }
             }
             
             
              if(listUtilisateur.get(i).getRole().equals("administrateur")){
                 if(listUtilisateur.get(i).getEmail().equals(email) && listUtilisateur.get(i).getPassword().equals(password) ){
                	 System.out.println("thats true admin !!!");
                  HttpSession admin= request.getSession();
                  admin.setAttribute("role",listUtilisateur.get(i).getRole());
                  admin.setAttribute("nom",listUtilisateur.get(i).getLastName());
                  path="welcome";
                 }
                 else {
                	 path="login";
                 }
             }
           } 
		 return new ModelAndView(path);
	}
	@RequestMapping(value ="/listApprenant" ,method=RequestMethod.GET)
	public ModelAndView listeApprenant(HttpServletRequest request){
		List<Student>listUtilisateur= getStudentService().getListStudentValidation();
		System.out.println(listUtilisateur.size());
		System.out.println(listUtilisateur.get(0).getEmail());
		request.setAttribute("listApprenant", listUtilisateur);
		return new ModelAndView("listApprenant");
	}
	@RequestMapping(value ="/valider/{id}" ,method=RequestMethod.GET)
	public ModelAndView updateValidation(HttpServletRequest request,@PathVariable int id){
		System.out.println("le id est :"+id);
		getStudentService().updateValider(id);
		return new ModelAndView("listApprenant");
	}
}
