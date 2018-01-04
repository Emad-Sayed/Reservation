<jsp:include page="header.jsp" />      


<!-- MAIN -->
<main role="main">
    <!-- Content -->
    <article>

        <section class="section-top-padding background-white">



            <div class="ControlBoth">
                <div class="form-style-2" style="float: left;">
                    <div class="form-style-2-heading">Enter Employee Branch</div>

                    <form action="" method="post">
                        <label for="field1"><span>Branch Name  <span class="required">*</span></span><input id='Branch_Name' type="text" class="input-field" name="field1" value="" /></label>

                        <div style="margin-top: 50px;margin-left: 60px;" class="center">
                            <button onclick="SearchEmployee()" type="button" class="btn  ">Search Employee</button>
                        </div>

                    </form>
                </div>
                <div class="form-style-2" style="float: right">
                    <div class="form-style-2-heading">Employee Information</div>

                    <form action="" method="post">
                        <form action="" method="post">
                            <label for="field1"><span>Fname <span class="required">*</span></span><input id='Fname' type="text" class="input-field" name="Fname" value="" readonly/></label>
                            <label for="field2"><span>Lname <span class="required">*</span></span><input id='Lname' type="text" class="input-field" name="Lname" value="" readonly/></label>
                            <label for="field2"><span>Phone <span class="required">*</span></span><input id='Phone' type="text" class="input-field" name="Phone" value="" readonly/></label>

                            <label for="field2"><span>Email <span class="required">*</span></span><input id='Email' type="text" class="input-field" name="Email" value="" readonly/></label>
                            <label for="field2"><span>Password <span class="required">*</span></span><input id='Password' type="text" class="input-field" name="Password" value="" readonly/></label>
                            <label for="field2"><span>Branch<span class="required">*</span></span><input id='Branch' type="text" class="input-field" name="Branch" value="" readonly/></label>

                            <div style="margin-top: 20px;margin-left: 60px;" class="center">
                                <button onclick="AddTime()" type="button" class="btn btn-danger">Delete Employee</button>                                    
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
<script type="text/javascript" src="js/JsearchEmployee.js"></script> 
</body>
</html>