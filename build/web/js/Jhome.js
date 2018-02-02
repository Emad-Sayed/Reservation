window.onload = function ()
{
    GetParagraphContent();
};
var http = new XMLHttpRequest();
function GetParagraphContent()
{

    http.onreadystatechange = PT;

    function PT()
    {
        var data = http.responseText;
        var obj = JSON.parse(data);
        if (http.readyState == 4 && http.status == 200)
        {
            for (var i = (obj.length-1); i >=0; i--)
            {
                var title = document.createElement("h1");
                title.setAttribute("class", "text-dark text-s-size-30 text-m-size-40 text-l-size-headline text-thin text-line-height-1");
                title.innerHTML = obj[i].title;
                var para = document.createElement("p");
                para.setAttribute("class", "margin-bottom-0 text-size-16 text-dark");
                para.innerHTML = obj[i].paragraph;
                document.getElementById("posts").appendChild(title);
                document.getElementById("posts").appendChild(para);
            }

        }
    }
    http.open("GET", "home_loader", true);
    http.send(null);
}