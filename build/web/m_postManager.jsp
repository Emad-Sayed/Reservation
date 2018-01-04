<jsp:include page="header.jsp" />      


<!-- MAIN -->
<main role="main">
    <!-- Content -->
    <article>

        <section class="section-top-padding background-white">



            <div class="ControlThreeDiv">
                <div class="form-style-2 ThreeDiv" >
                    <div class="form-style-2-heading">Post Details</div>

                    <form  method="post">
                        <label for="field1"><span>Title <span class="required">*</span></span><input id='title' type="text" class="input-field" value="" /></label>
                        <label for="field2"><span>Descript <span class="required">*</span></span><textarea id='para'  class="input-field" value="" rows="10" cols="17" ></textarea></label>

                        <input type="button" id="Add_Post" onclick="AddPost()" class="btn " value="Add Post">
                    </form>
                </div>    
                <div class="form-style-2 ThreeDiv">
                    <div class="form-style-2-heading">Enter Post Title</div>

                    <form action="" method="post">
                        <label for="field1"><span> Title  <span class="required">*</span></span><input id='SearchItem' type="text" class="input-field"  value="" /></label>

                        <button type="button" id="Search_Button" onclick="SearchPost()" class="btn ">Search Post</button>

                    </form>
                </div>      
                <div class="form-style-2 ThreeDiv" >
                    <div class="form-style-2-heading">Post Information</div>

                    <form action="" method="post">
                        <label for="field1"><span>Title <span class="required">*</span></span><input id='_title' type="text" class="input-field" name="field1"  readonly/></label>
                        <label for="field2"><span>Descript <span class="required">*</span></span><textarea id='_para'  class="input-field" name="field2" rows="10" cols="17"  readonly></textarea></label>

                        <input type="button" id="Delete_Post" onclick="DeletePost()" class="btn " value="Delete Post">
                    </form>
                </div>     
            </div>
        </section>
    </article>
</main>
<div style="clear: both"></div>
<!-- FOOTER -->
<jsp:include page="footer.jsp" />   
<script type="text/javascript" src="js/JPostManage.js"></script> 
</body>
</html>