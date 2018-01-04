
var http = new XMLHttpRequest();
function SearchPost()
{
    http.onreadystatechange = PT;

    function PT()
    {
        var data = http.responseText;
        var obj = JSON.parse(data);
        if (http.readyState == 4 && http.status == 200)
        {
            if (obj[0].title == 'null')
            {
                document.getElementById("_title").value = "";
                document.getElementById("_para").innerHTML = "";
                alert("Not Found");
            } else
            {
                document.getElementById("_title").value = obj[0].title;
                document.getElementById("_para").innerHTML = obj[0].para;
            }
        }
    }
    http.open("POST", 'search_post?SearchItem=' + document.getElementById("SearchItem").value, true);
    http.send(null);

}

function AddPost()
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
    http.open("POST", 'add_post?title=' + document.getElementById("title").value + '&para=' + document.getElementById("para").value, true);
    http.send(null);

}

function AddPost()
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
    http.open("POST", 'add_post?title=' + document.getElementById("title").value + '&para=' + document.getElementById("para").value, true);
    http.send(null);

}

function DeletePost()
{
    http.onreadystatechange = PT;

    function PT()
    {
        var data = http.responseText;
        if (http.readyState == 4 && http.status == 200)
        {
            if (data == 'true')
            {
                document.getElementById("_title").value = "";
                document.getElementById("_para").innerHTML = "";
                alert("Post Deleted!");
            } else
            {
                alert("Post Not Found!");

            }
        }
    }
    http.open("POST", 'delete_post?title=' + document.getElementById("_title").value, true);
    http.send(null);

}