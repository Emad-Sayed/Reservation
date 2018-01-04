var http = new XMLHttpRequest();
function Profile()
{
    http.onreadystatechange = PT;

    function PT()
    {
        var data = http.responseText;
        if (http.readyState == 4 && http.status == 200)
        {
            alert(data);
        }
    }
    http.open("POST", 'Profile?FNAME=' + document.getElementById("FN").value + '&LNAME=' + document.getElementById("LN").value, true);
    http.send(null);

}