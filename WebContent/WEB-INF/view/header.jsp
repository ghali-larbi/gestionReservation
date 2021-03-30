<%@page import="org.springframework.web.servlet.ModelAndView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Page</title>
<link rel="stylesheet"href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"crossorigin="anonymous">
          <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="http://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
<style>
       .about .content {
  background-color: #f6f9ff;
  padding: 40px;
}

.about h3 {
  font-size: 14px;
  font-weight: 700;
  color: #4154f1;
  text-transform: uppercase;
}

.about h2 {
  font-size: 24px;
  font-weight: 700;
  color: #012970;
}

.about p {
  margin: 15px 0 30px 0;
  line-height: 24px;
}

.about .btn-read-more {
  line-height: 0;
  padding: 15px 40px;
  border-radius: 4px;
  transition: 0.5s;
  color: #fff;
  background: #4154f1;
  box-shadow: 0px 5px 25px rgba(65, 84, 241, 0.3);
}

.about .btn-read-more span {
  font-family: "Nunito", sans-serif;
  font-weight: 600;
  font-size: 16px;
  letter-spacing: 1px;
}

.about .btn-read-more i {
  margin-left: 5px;
  font-size: 18px;
  transition: 0.3s;
}

.about .btn-read-more:hover i {
  transform: translateX(5px);
}

                            
</style>
</head>
<body>
<%
   if(session.getAttribute("role")==null ){
        	   response.sendRedirect("/login");  
           }
       %>
     
<header>
		<nav class=" bg-dark navbar navbar-expand-md navbar-dark ">
			<div>
				<a href="" class="navbar-brand">school   </a>
			</div>

			<ul class="navbar-nav ml-auto">
				<li><a href="home.jsp"class="nav-link">home</a></li>        
                                    <%
                                        if(session.getAttribute("role")!=null ){
                                            if(session.getAttribute("role").equals("administrateur")){%>
                                             <li><a href="listApprenant" class="nav-link">list apprenant</a></li>
                                              <li><a href="listReservation" class="nav-link">list Resevation</a></li>
                                              <li><a href="calendrier" class="nav-link">calendrier</a></li>
                                           <%}
                                            if(session.getAttribute("role").equals("apprenant")){%>
                                             <li><a href="reserver"class="nav-link">reserver</a></li>
                                            <%}
                                        }     
                                    %>
                                        <li><a href=""class="nav-link"><i class="fas fa-user-circle" style="font-size:30px;margin-top:-7px"></i>&nbsp <%= session.getAttribute("nom") %> </a></li>
                                        <li><a href="logout" class="btn btn-md btn-danger">deconnexion</a></li>
			</ul>
		</nav>
	</header> 
	<img src="http://via.placeholder.com/640x360" width="100%" height="300">
	