window.onload = function ()
{
    ListPage();
};
var http = new XMLHttpRequest();
function ListPage()
{
    http.onreadystatechange = PT;

    function PT()
    {
        var data = http.responseText;
        var obj = JSON.parse(data);
        if (http.readyState == 4 && http.status == 200)
        {
            if (obj.length > 1)
                document.getElementById("Delte_B").setAttribute("style", "visibility: visible");
            document.getElementById("name").innerHTML = obj[0].E_FNAME + " " + obj[0].E_LNAME;
            var parent = document.getElementById("list");
            while (parent.hasChildNodes())
            {
                parent.removeChild(parent.lastChild);
            }
            for (var i = 1; i < obj.length; i++)
            {
                var L = document.createElement("li");
                var S = document.createElement("span");
                //var B = document.createElement("button");
                //B.setAttribute("class","btn btn-success");
                //B.setAttribute("type","submit");                
                //B.innerHTML="Success";
                S.setAttribute("class", "badge");
                //S.appendChild(B);
                L.setAttribute("class", "list-group-item");
                L.innerHTML = obj[i].FNAME + " " + obj[i].LNAME+" ";
                L.appendChild(S);
                parent.appendChild(L);
            }

        }
    }
    http.open("GET", "e_listLoader", true);
    http.send(null);
}
setInterval(ListPage,10000);
function DeleteFromList()
{
    var con = confirm("Client Will Delete From List ,Are you Sure Client is Served?");
    if (con)
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
        http.open("GET", "e_deleteFromList", true);
        http.send(null);
    }
}