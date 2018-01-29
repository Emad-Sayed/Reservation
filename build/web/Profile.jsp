<jsp:include page="header.jsp" />      


            <!-- MAIN -->
            <main role="main">
                <!-- Content -->
                <article>


                    <section class="section-top-padding background-white">



                        <div class="ControlBoth">
                        <div class="form-style-2" style="float: left;">
                            <div class="form-style-2-heading">Profile Information</div>

                            <form  method="post">
                                <label for="field1"><span> First Name  <span class="required">*</span></span><input id='FNAME' type="text" class="input-field" name="Name" value="" /></label>
                                      <label for="field1"><span>Last Name  <span class="required">*</span></span><input id='LNAME' type="text" class="input-field" name="Director" value="" /></label>
                                <label for="field1"><span> Phone  <span class="required">*</span></span><input id='PHONE' type="text" class="input-field" name="Phone" value="" /></label>
                          
                                <label for="field2"><span> User Type  <span class="required">*</span></span><input id='TYPE' type="text" class="input-field" name="Description" value="" readonly/></label>


                                    <div style="margin-top: 50px"class="center">
                                        <button  onclick="Update()" type="button" class="btn green_">Update</button>
                                    </div>

                            </form>
                        </div>
                        <div class="form-style-2" style="float: right">
                            <div class="form-style-2-heading">Change Password</div>

                            <form action="" method="post">
                                <label for="field1"><span> Old Password  <span class="required">*</span></span><input id='Cat_Name_' type="text" class="input-field" name="field1" value="" /></label>
                                <label for="field1"><span> New Password  <span class="required">*</span></span><input id='Cat_Name_' type="text" class="input-field" name="field1" value="" /></label>

                                    <div style="margin-top: 85px"class="center">
                                        <button onclick="ChangePassword()" type="button" class="btn btn-danger">Change Password</button>                                    
                                    </div>

                            </form>
                        </div>     
                        </div>
                    </section>
                </article>
            </main>
            <div style="clear: both"></div>
            <!-- FOOTER -->
<jsp:include page="footer.jsp" />   
<script type="text/javascript" src="js/JProfile.js"></script> 
</body>
</html>