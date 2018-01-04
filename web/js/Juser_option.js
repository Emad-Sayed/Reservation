window.onload = function ()
{
    GetBranches();
};
var http = new XMLHttpRequest();
function GetBranches()
{
    http.onreadystatechange = PT;

    function PT()
    {
        
        var data = http.responseText;
        var obj = JSON.parse(data);
        if (http.readyState == 4 && http.status == 200)
        {
            if (obj.length === 0)
            {
                document.getElementById("Message").innerHTML="No Branches in This Category!";
            }
            else
            {
                document.getElementById("Message").innerHTML="Select The Branch";                
                for (var i = 0; i < obj.length; i++)
                {
                    var Ch = document.createElement("INPUT");
                    Ch.setAttribute("type", "submit");
                    Ch.setAttribute("id", obj[i].branch);
                    Ch.setAttribute("name", "branch");                    
                    Ch.setAttribute("value", obj[i].branch);
                    Ch.setAttribute("class", "s-12 submit-form button text-white");
                    Ch.setAttribute("style","background-color:#A7A37E;");
                    document.getElementById("B_C").appendChild(Ch);
                }
            }

        }
    }
    http.open("GET", "branches_loader2", true);
    http.send(null);
}