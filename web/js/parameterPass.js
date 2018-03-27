var o = new Object();
o.name = "lucy";
var num = 123;
function add(num) {
    num++;
}
add(num);
console.log(num);
function changeObject(o) {
    o.name = "jack";
    o.age = 16;
}
changeObject(o);
console.log(o);
var loader = {
    name : "123",
    age : 19
}
function second() {
    with (loader)
    {
        var n = name;
        var a = age;
    }
    console.log(n);
    console.log(a);
}
second();