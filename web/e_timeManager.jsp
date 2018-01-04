<jsp:include page="header.jsp" />      


            <!-- MAIN -->
            <main role="main">
                <!-- Content -->
                <article>
                    <header class="section background-white">
                    <div class="form-style-2">
                        <div id="Title" class="form-style-2-heading">Branch Work Time</div>
                        <form method="post">
                            <label for="field1"><span>Start Hour <span class="required">*</span></span><input type="number" id='SH' type="text" class="input-field" name="SH" value="" /></label>
                            <label for="field2"><span>Start Minute <span class="required">*</span></span><input type="number" id='SM' type="text" class="input-field" name="SM" value="" /></label>
                            <label for="field2"><span>End Hour <span class="required">*</span></span><input type="number" id='EH' type="text" class="input-field" name="EH" value="" /></label>
                            <label for="field2"><span>End Minute<span class="required">*</span></span><input type="number" id='EM' type="text" class="input-field" name="EM" value="" /></label>                            
                                </label>                             
                                <h4>Hint: Time 24 hour based Not 12 hour!!</h4>
                                <h4>At the End Of Your Day u must Clear The List !!</h4>  
                                <h4>If u want To Update the Time Just Make New Submit!!</h4>                                                                
                                <button onclick="AddTime()" type="button" class="btn green_">Submit</button>                                    
                                <button onclick="ClearList()" type="button" class="btn btn-danger">Clear List </button>                                    
                    </div>
                    </header>
                    </article>
                </main>
                    <!-- FOOTER -->
<jsp:include page="footer.jsp" />   
<script type="text/javascript" src="js/e_timeManager.js"></script> 
</body>
</html>