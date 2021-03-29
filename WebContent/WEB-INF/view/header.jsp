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

</head>
<body>
<header>
		<nav class=" bg-dark navbar navbar-expand-md navbar-dark ">
			<div>
				<a href="" class="navbar-brand">school   </a>
			</div>

			<ul class="navbar-nav ml-auto">
				<li><a href="home.jsp"class="nav-link">home</a></li>
				 <%
           if(session.getAttribute("role")==null ){
        	   response.sendRedirect("/");  
           }
       %>
                                    <%
                                        if(session.getAttribute("role")!=null ){
                                            if(session.getAttribute("role").equals("administrateur")){%>
                                             <li><a href="listePoterie" class="nav-link">list Resevation</a></li>
                                           <%}
                                            if(session.getAttribute("role").equals("apprenant")){%>
                                             <li><a href="listePoterieClient"class="nav-link">inscription</a></li>
                                            <%}
                                        }     
                                    %>
                                        <li><a href=""class="nav-link"><i class="fas fa-user-circle" style="font-size:30px;margin-top:-7px"></i>&nbsp <%= session.getAttribute("nom") %> </a></li>
                                        <li><a href="logout" class="btn btn-md btn-danger">deconnexion</a></li>
			</ul>
		</nav>
	</header> 
	