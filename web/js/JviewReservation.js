var http = new XMLHttpRequest();

function GetNumber()
{
    document.getElementById("Specific").setAttribute("style", "visibility:hidden");
    http.onreadystatechange = PT;

    function PT()
    {
        var data = http.responseText;
        var obj = JSON.parse(data);
        if (http.readyState == 4 && http.status == 200)
        {
            if (obj[0].Flag == 'true')
            {
                document.getElementById("FNAME").value = obj[0].Fname;
                document.getElementById("LNAME").value = obj[0].Lname;
                document.getElementById("NUM").value = obj[0].My_Number;
                document.getElementById("Curr_Number").value = obj[0].Curr_Number;
                document.getElementById("branch").value = obj[0].branch;

            } else
            {
                document.getElementById("FNAME").value = obj[0].Fname;
                document.getElementById("LNAME").value = obj[0].Lname;
                document.getElementById("NUM").value = obj[0].My_Number;
                document.getElementById("Curr_Number").value = obj[0].Curr_Number;
                document.getElementById("branch").value = obj[0].branch;
            }
        }
    document.getElementById("Special").value="";        
    }
    http.open("POST", 'u_selectRoleMethod?Special='+document.getElementById("Special").value, true);
    http.send(null);
}

function Show()
{
    document.getElementById("Specific").setAttribute("style", "visibility:visible;margin-top:40px");
}

function DeleteNumber()
{
    var result = confirm("Are You Sure You Want To Delete Your Reservation?");
    if (result)
    {
        document.getElementById("Specific").setAttribute("style", "visibility:hidden");
        http.onreadystatechange = PT;

        function PT()
        {
            var data = http.responseText;
            if (http.readyState == 4 && http.status == 200)
            {
                alert(data);
                document.getElementById("FNAME").value = "";
                document.getElementById("LNAME").value = "";
                document.getElementById("NUM").value = "";
                document.getElementById("Curr_Number").value = "";
                document.getElementById("branch").value = "";                
            }
        }
        http.open("POST", 'u_DeleteNumber', true);
        http.send(null);
    }
}
