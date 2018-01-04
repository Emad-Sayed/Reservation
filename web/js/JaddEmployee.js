var http = new XMLHttpRequest();

function AddEmployee()
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
    http.open("POST", 'm_addEmployee?Fname=' + document.getElementById("Fname").value
            + '&Lname=' + document.getElementById("Lname").value
            + '&Email=' + document.getElementById("Email").value
            + '&Password=' + document.getElementById("Password").value
            + '&Branch=' + document.getElementById("Branch").value 
            + '&Phone=' + document.getElementById("Phone").value        
            + '&SecretWord=' + document.getElementById("SecretWord").value, true);
    http.send(null);
}