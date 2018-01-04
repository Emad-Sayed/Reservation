<jsp:include page="header.jsp" />      


            <!-- MAIN -->
            <main role="main">
                <!-- Content -->
                <article>
                    <header class="section background-white">
                        <div style=" margin: 0 auto; width: 250px;text-align: center"> 
                           <h3>Vodafone Waiting List</h3> 
                           <h3 id="name" ></h3> 
                        </div>
                        <form>
                        <ul id="list" class="list-group">
                <!--            <li class="list-group-item">Emad Sayed<span class="badge"><button type="submit" class="btn btn-success">Success</button></span></li>         -->
                        </ul>
                            <div style="visibility: hidden" id="Delte_B" class="em_center">  <button onclick="DeleteFromList()" class=" btn-danger s-12  button text-white" type="submit">Delete The Top</button></div>
                        </form>
                    </header>

                </article>
            </main>

            <!-- FOOTER -->
<jsp:include page="footer.jsp" />   
<script type="text/javascript" src="js/JemployeeList.js"></script> 
</body>
</html>