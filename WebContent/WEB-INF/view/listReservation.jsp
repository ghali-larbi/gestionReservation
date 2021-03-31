<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp" />
 <div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center mt-5">listeReservation</h3>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						                        <th>id </th>
						                        <th>nom </th>
                                                <th>date </th>
                                                <th>heure</th>
                                                <th>nombre place</th>
                                                <th>action</th>
					</tr>
				</thead>
				<tbody>    
                    <c:forEach var="reservation" items="${listReservation}">
                    
						<tr>
					        <td>${reservation.student_table.id}</td>
					        <td>${reservation.student_table.firstName}</td>
	   				      <td>${reservation.dateCalendrier}</td>
                            <td>${reservation.heureCalendrier}</td>
                            <td>${reservation.nombrePlace}</td>
							<td><a class="btn btn-md btn-warning" href="validerReservation/${reservation.idresevation}">valider</a></td>
						</tr>
						<c:if test="${reservation.nombrePlace} > 0">
						<td>${reservation.nombrePlace}</td>
						</c:if>
					</c:forEach>

				</tbody>

			</table>
		</div>
	</div>

 

<jsp:include page="footer.jsp" />