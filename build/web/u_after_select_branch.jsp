<jsp:include page="header.jsp" />      


<!-- MAIN -->
<main role="main">
    <!-- Content -->
    <article>

        <section class="section-top-padding background-white">



            <div class="ControlBoth">
                <div class="form-style-2" style="float: left;">
                    <div class="form-style-2-heading">Select The Way Of Reservation</div>

                    <form action="" method="post">

                        <div  class="center">
                            <input type="button"  onclick="GetNumber()" class="btn " value="Get Your Number">
                            <input type="button" id="Spe" onclick="Show()" class="btn " value="Get Special Number">
                        </div>
                        <div id="Specific" style="visibility:hidden">
                            <label for="field2"><span>Enter Specific Number<span class="required">*</span></span><input type="number" id='Special' type="text" class="input-field" name="Special" value="" /></label>         
                            <input onclick="GetNumber()" type="button"  class="btn " value="Submit">
                        </div>
                    </form>
                </div>
                <div class="form-style-2" style="float: right">
                    <div class="form-style-2-heading">Reservation Information</div>

                    <form action="" method="post">
                        <label for="field1"><span>First Name <span class="required">*</span></span><input id='FNAME' type="text" class="input-field" name="field1" value="" readonly/></label>
                        <label for="field2"><span>Last Name <span class="required">*</span></span><input id='LNAME' type="text" class="input-field" name="field2" value="" readonly/></label>
                        <label for="field2"><span>Branch<span class="required">*</span></span><input id='branch' type="text" class="input-field" name="field2" value="" readonly/></label>
                        <label for="field2"><span>Number <span class="required">*</span></span><input id='NUM' type="text" class="input-field" name="field2" value="" readonly/></label>
                        <label for="field2"><span>Current Number <span class="required">*</span></span><input id='Curr_Number' type="text" class="input-field" name="field2" value="" readonly/></label>
                        <button onclick="DeleteNumber()" type="button" class="btn btn-danger">Delete Reservation</button>                                    

                    </form>
                </div>     
            </div>
        </section>
    </article>
</main>
<div style="clear: both"></div>
<!-- FOOTER -->
<jsp:include page="footer.jsp" />   
<script type="text/javascript" src="js/JviewReservation.js"></script> 
</body>
</html>