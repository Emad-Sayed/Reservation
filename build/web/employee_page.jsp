<jsp:include page="header.jsp" />      
<!-- MAIN -->
<main role="main">
    <!-- Content -->
    <article>
        <header class="section background-white">
            <div class="line text-center">    
                <h4 class="text-size-20 margin-bottom-20 text-dark text-center">Employee Options</h4>
                <form action="e_employeeManager" name="contactForm" class="customform" method="post">
                    <div class="ControlOne" >
                        <input name="B" style="background-color:#19b9e7" class="s-12 submit-form button  text-white" type="submit" value="Time Manager">
                        <input name="B" style="background-color:#19b9e7" class="s-12 submit-form button  text-white" type="submit" value="View List">                           
                </form>
            </div>     
            </div>  
        </header>

    </article>
</main>

<!-- FOOTER -->
<jsp:include page="footer.jsp" />   
<script type="text/javascript" src="js/Jhome.js"></script> 
</body>
</html>