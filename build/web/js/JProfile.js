window.onload = function ()
{
    Profile();
};
var http = new XMLHttpRequest();
function Profile()
{
    http.onreadystatechange = PT;
    function PT()
    {

        var data = http.responseText;
        var obj = JSON.parse(data);
        if (http.readyState == 4 && http.status == 200)
        {
            document.getElementById("FNAME").value = obj[0].FNAME;
            document.getElementById("LNAME").value = obj[0].LNAME;
            document.getElementById("PHONE").value = obj[0].PHONE;
            document.getElementById("TYPE").value = obj[0].TYPE;

        }
    }
    http.open("GET", "Profile", true);

    http.send(null);
}
function Update()
{

}
function ChangePassword()
{

}