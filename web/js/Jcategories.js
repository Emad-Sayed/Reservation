window.onload = function ()
{

    GetCategories();
};
var http = new XMLHttpRequest();
function GetCategories()
{
    http.onreadystatechange = PT;

    function PT()
    {
        var data = http.responseText;
        var obj = JSON.parse(data);
        if (http.readyState == 4 && http.status == 200)
        {
            for (var i = 0; i < obj.length; i++)
            {
                var Ch = document.createElement("BUTTON");
                var t = document.createTextNode(obj[i].category);
                Ch.setAttribute("id",obj[i].category);
                Ch.setAttribute("value",obj[i].category);                
                Ch.setAttribute("name","CAT");                
                Ch.setAttribute("class", "s-12 submit-form button background-primary text-white");
                Ch.appendChild(t);
                document.getElementById("branch_container").appendChild(Ch);
            }
        }
    }
    http.open("GET", "category_loader", true);
    http.send(null);
}