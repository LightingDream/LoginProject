function show()
{
    var now = new Date();
    var h = now.getHours();
    var m = now.getMinutes();
    var s = now.getSeconds();
    h = check(h);
    m = check(m);
    s = check(s);
    var obj = document.getElementById("time");
    obj.innerHTML = h + ":" + m + ":" + s;
    setTimeout("show()", 1000);
}

function check(x)
{
    return x < 10 ? "0" + x : x;
}