<jsp:include page="header.jsp" />
 <h1 class="mt-5 col-12 d-flex justify-content-center">Ajouter calendrier</h1>
        <div class="col-12 d-flex justify-content-center mt-3">   
        <div class="col-6 ">
             <form action="ajouterCalendrier" method="post">
               <div class="form-group">
                <label for="exampleInputnom">date </label>
                <input class="form-control" id="exampleInputnom" type=date name="dateCalendrier">
                </div>
                  <div class="form-group">
                <label for="exampleInputnom">heure </label>
                <input class="form-control" id="exampleInputnom" type="text" name="heureCalendrier">
                </div>
                  <div class="form-group">
                <label for="exampleInputnom">nombre place</label>
                <input class="form-control" id="exampleInputnom" type="text" name="nombrePlace">
                </div>
               <input type="submit" class="btn btn-primary" value="ajouter">
            </form>
        </div>
        </div>
       
<jsp:include page="footer.jsp" />