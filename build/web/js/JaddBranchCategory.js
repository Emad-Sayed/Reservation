var http = new XMLHttpRequest();

function AddBranch()
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
    http.open("POST", 'm_addBranch?Name=' + document.getElementById("Name_").value
            + '&Director=' + document.getElementById("Director_").value
            + '&Phone=' + document.getElementById("Phone_").value
            + '&Description=' + document.getElementById("Description_").value
            + '&Category=' + document.getElementById("Category_").value, true);
    http.send(null);
}

function AddCategory()
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
    http.open("POST", 'm_addCategory?Name=' + document.getElementById("Cat_Name_").value,true);
    http.send(null);
}


