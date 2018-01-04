var http = new XMLHttpRequest();

function SearchEmployee()
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
                document.getElementById("Fname").value=obj[0].Fname;
                document.getElementById("Lname").value=obj[0].Lname;
                document.getElementById("Email").value=obj[0].Email;
                document.getElementById("Password").value=obj[0].Password;
                document.getElementById("Branch").value=obj[0].Branch;
                document.getElementById("Phone").value=obj[0].Phone;
            }
            else
            {
                alert("No Employee For this Branch");
                document.getElementById("Fname").value="";
                document.getElementById("Lname").value="";
                document.getElementById("Email").value="";
                document.getElementById("Password").value="";
                document.getElementById("Branch").value="";   
                document.getElementById("Phone").value="";                                
            }
        }
    }
    http.open("POST", 'm_searchEmployee?BranchName=' + document.getElementById("Branch_Name").value,true);
    http.send(null);
}