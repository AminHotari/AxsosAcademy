console.log("page loaded...");

var name1=document.querySelector(".card-name")
function fun1(){
    name1.innerText="Tood E";

}
var counter=2
var counter1=500

var hiden=document.querySelector("#remove1")
var num=document.querySelector("#incr-cout")
function hide(){
    hiden.remove();
    counter --
    num.innerText=counter;

}

var hiden1=document.querySelector("#remove2")
var num=document.querySelector("#incr-cout")
function hide1(){
    hiden1.remove();
    counter--
    num.innerText=counter;
}

var hiden=document.querySelector("#remove1")
var num=document.querySelector("#incr-cout")
var num1=document.querySelector("#incr-cout1")
function incr(){
    hiden.remove();
    counter --
    counter1 ++
    num.innerText=counter;
    num1.innerText=counter1;

}

var hiden1=document.querySelector("#remove2")
var num=document.querySelector("#incr-cout")
var num1=document.querySelector("#incr-cout1")
function incr1(){
    hiden1.remove();
    counter --
    counter1 ++
    num.innerText=counter;
    num1.innerText=counter1;

}


