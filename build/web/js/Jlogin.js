
var http = new XMLHttpRequest();
function LoginChecker()
{
    http.onreadystatechange = PT;

    function PT()
    {
        var data = http.responseText;
        if (http.readyState == 4 && http.status == 200)
        {
            if(data=='true')
                window.location="home.jsp";
            else
            document.getElementById("error").innerHTML="Error in Mail or Password";
        }
    }
    http.open("POST",'Login_manager?mail='+document.getElementById("mail").value+'&pass='+document.getElementById("pass").value, true);
    http.send(null);
}