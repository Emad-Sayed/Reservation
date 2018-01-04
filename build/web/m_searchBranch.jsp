<jsp:include page="header.jsp" />      


            <!-- MAIN -->
            <main role="main">
                <!-- Content -->
                <article>

                    <section class="section-top-padding background-white">



                        <div class="ControlBoth">
                        <div class="form-style-2" style="float: left;">
                            <div class="form-style-2-heading">Enter Branch Name</div>

                            <form action="" method="post">
                                <label for="field1"><span> Name  <span class="required">*</span></span><input id='Name' type="text" class="input-field" name="field1" value="" /></label>

                                    <div style="margin-top: 50px;margin-left: 60px;" class="center">
                                        <button onclick="SearchBranch()" type="button" class="btn ">Search Branch</button>
                                    </div>

                            </form>
                        </div>
                        <div class="form-style-2" style="float: right">
                            <div class="form-style-2-heading">Employee Information</div>

                            <form action="" method="post">
                            <label for="field1"><span>Name <span class="required">*</span></span><input id='Name_' type="text" class="input-field" name="field1" value="" readonly/></label>
                            <label for="field2"><span>Director <span class="required">*</span></span><input id='Director_' type="text" class="input-field" name="field2" value="" readonly/></label>
                            <label for="field2"><span>Descript <span class="required">*</span></span><input id='Descript_' type="text" class="input-field" name="field2" value="" readonly/></label>
                            <label for="field2"><span>Phone <span class="required">*</span></span><input id='Phone_' type="text" class="input-field" name="field2" value="" readonly/></label>
                            <label for="field2"><span>Category <span class="required">*</span></span><input id='Category_' type="text" class="input-field" name="field2" value="" readonly/></label>
                                    <div style="margin-top: 20px;margin-left: 60px;" class="center">
                                        <button type="button" class="btn btn-danger ">Delete Branch</button>
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
<script type="text/javascript" src="js/JsearchBranch.js"></script> 
</body>
</html>