var http = new XMLHttpRequest();

function AddTime()
{
    var result = confirm("Are You Sure You Want to Add this Time?");
    if (result) {
        http.onreadystatechange = PT;

        function PT()
        {
            var data = http.responseText;
            if (http.readyState == 4 && http.status == 200)
            {
                alert(data);
            }
        }
        http.open("POST", 'e_timeManager?SH=' + document.getElementById("SH").value
                + '&SM=' + document.getElementById("SM").value
                + '&EH=' + document.getElementById("EH").value
                + '&EM=' + document.getElementById("EM").value, true);
        http.send(null);
    }
}


function ClearList()
{
    var result = confirm("Are You Sure You Want to Clear List?");
    if (result) {
        http.onreadystatechange = PT;

        function PT()
        {
            var data = http.responseText;
            if (http.readyState == 4 && http.status == 200)
            {
                alert(data);
            }
        }
        http.open("POST", 'e_clearList', true);
        http.send(null);
    }
}