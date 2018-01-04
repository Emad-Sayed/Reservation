var http = new XMLHttpRequest();
function find(ServletName)
{

    http.onreadystatechange = PT;

    function PT()
    {
        var data = http.responseText;
        if (http.readyState == 4 && http.status == 200)
        {
            alert("Done!!! other side");
        }
    }
    http.open("GET", ServletName+"?Phone1="+document.getElementById('phone1').value, true);
    http.send(null);
}
function Mine()
{

    var Ch = document.createElement("BUTTON");
    var t = document.createTextNode("CLICK ME");

    Ch.setAttribute("class", "s-12 submit-form button background-primary text-white");
    Ch.appendChild(t);
    document.getElementById("M").appendChild(Ch);

}