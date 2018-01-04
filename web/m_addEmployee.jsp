<jsp:include page="header.jsp" />      


            <!-- MAIN -->
            <main role="main">
                <!-- Content -->
                <article>
                    <header class="section background-white">
                    <div class="form-style-2">
                        <div class="form-style-2-heading">Provide Employee information</div>
                        <form action="" method="post">
                            <label for="field1"><span>Fname <span class="required">*</span></span><input id='Fname' type="text" class="input-field" name="field1" value="" /></label>
                            <label for="field2"><span>Lname <span class="required">*</span></span><input id='Lname' type="text" class="input-field" name="field2" value="" /></label>
                            <label for="field2"><span>Phone <span class="required">*</span></span><input id='Phone' type="text" class="input-field" name="field2" value="" /></label>
                            <label for="field2"><span>Email <span class="required">*</span></span><input id='Email' type="text" class="input-field" name="field2" value="" /></label>
                            <label for="field2"><span>Password <span class="required">*</span></span><input id='Password' type="text" class="input-field" name="field2" value="" /></label>
                            <label for="field2"><span>Secret Word<span class="required">*</span></span><input id='SecretWord' type="text" class="input-field" name="field2" value="" /></label>                            
                                <label for="field2"><span>Branch<span class="required">*</span></span>
                                    <div class="form-group">
                                        <select class="form-control" id="Branch" name="Branch">
                                            <option>Vodafone</option>
                                            <option>Mobinil</option>
                                            <option>TeData</option>
                                            <option>Prince</option>
                                            <option>Hamza</option>
                                            <option>Sweet</option>
                                            
                                        </select>
                                    </div>
                                </label>                                 
                            <div style="margin-top: 40px"class="center">
                                <button onclick="AddEmployee()" type="button" class="btn green_">Submit</button>                                    
                                    </div>
                        </form>
                    </div>
                    </header>
                    </article>
                </main>
                    <!-- FOOTER -->
<jsp:include page="footer.jsp" />   
<script type="text/javascript" src="js/JaddEmployee.js"></script> 
</body>
</html>