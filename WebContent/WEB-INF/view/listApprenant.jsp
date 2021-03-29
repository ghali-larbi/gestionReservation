<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp" />

<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center mt-5">List of apprenant</h3>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						                        
                                                <th>nom</th>
                                                <th>telephone</th>
                                                <th>email</th>
                                                <th>action</th>
					</tr>
				</thead>
				<tbody>
					
                                     
                    <c:forEach var="apprenant" items="${listApprenant}">
						<tr>
	   				      <td>${apprenant.firstName}</td>
                            <td>${apprenant.email}</td>
                            <td>${apprenant.phone}</td>
							<td><a class="btn btn-md btn-warning" href="valider/${apprenant.id}">valider</a></td>
						</tr>
					</c:forEach>

				</tbody>

			</table>
		</div>
	</div>








<jsp:include page="footer.jsp" />