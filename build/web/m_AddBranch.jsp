<jsp:include page="header.jsp" />      
    <script>
        window.onload=function LoadCategory()
    {
        http.onreadystatechange = PT;

        function PT()
        {

            var data = http.responseText;
            var obj  =JSON.parse(data);
            if (http.readyState == 4 && http.status == 200)
            {
                var Parent=document.getElementById("Category_");
                for (var i = 1; i < obj.length; i++)
                {
                    var L = document.createElement("option");
                    L.innerHTML = obj[i].CAT ;
                    Parent.appendChild(L);
                }
            }
        }
        http.open("GeT", 'LoadCategory',true);
        http.send(null);
    }
</script>

            <!-- MAIN -->
            <main role="main">
                <!-- Content -->
                <article>


                    <section class="section-top-padding background-white">



                        <div class="ControlBoth">
                        <div class="form-style-2" style="float: left;">
                            <div class="form-style-2-heading">New Brunch</div>

                            <form  method="post">
                                <label for="field1"><span> Name  <span class="required">*</span></span><input id='Name_' type="text" class="input-field" name="Name" value="" /></label>
                                      <label for="field1"><span>Director  <span class="required">*</span></span><input id='Director_' type="text" class="input-field" name="Director" value="" /></label>
                                <label for="field1"><span> Phone  <span class="required">*</span></span><input id='Phone_' type="text" class="input-field" name="Phone" value="" /></label>
                          
                                <label for="field2"><span> Description  <span class="required">*</span></span><input id='Description_' type="text" class="input-field" name="Description" value="" /></label>

                                <label for="field2"><span>Category<span class="required">*</span></span>
                                    <div class="form-group">
                                        <select class="form-control" id="Category_" name="Category">
                                            
                                        </select>
                                    </div>
                                </label>
                                    <div style="margin-top: 50px"class="center">
                                        <button  onclick="AddBranch()" type="button" class="btn">Add Brunch</button>
                                    </div>

                            </form>
                        </div>
                        <div class="form-style-2" style="float: right">
                            <div class="form-style-2-heading">New Category</div>

                            <form action="" method="post">
                                <label for="field1"><span> Name  <span class="required">*</span></span><input id='Cat_Name_' type="text" class="input-field" name="field1" value="" /></label>


                                    <div style="margin-top: 85px"class="center">
                                        <button onclick="AddCategory()" type="button" class="btn btn-danger">Add Category</button>                                    
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
<script type="text/javascript" src="js/JaddBranchCategory.js"></script> 
</body>
</html>