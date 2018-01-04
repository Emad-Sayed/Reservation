var http = new XMLHttpRequest();

function SearchBranch()
{
    http.onreadystatechange = PT;

    function PT()
    {
        var data = http.responseText;
        var obj  =JSON.parse(data);
        if (http.readyState == 4 && http.status == 200)
        {
            if(obj[0].Flag=='true')
            {
                document.getElementById("Name_").value=obj[0].Name;
                document.getElementById("Director_").value=obj[0].Director;
                document.getElementById("Descript_").value=obj[0].Descript;
                document.getElementById("Phone_").value=obj[0].Phone;
                document.getElementById("Category_").value=obj[0].Category;
                
            }
            else
            {
                alert("No Branch Founded");
                document.getElementById("Name_").value="";
                document.getElementById("Director_").value="";
                document.getElementById("Descript_").value="";
                document.getElementById("Phone_").value="";
                document.getElementById("Category_").value="";
                
           }
        }
    }
    http.open("POST", 'm_searchBranch?Name=' + document.getElementById("Name").value,true);
    http.send(null);
}