function aler(){
    alert("Loading weather report...")

}

var footer = document.querySelector("footer")
function dismiss(){
    footer.remove();

}

var red = document.querySelectorAll(".red");
var blue = document.querySelectorAll(".blue");

function convert(elem){
    if (elem.value == "°F"){
        for (var i=0; i<red.length; i++){
            red[i].innerText = Math.floor((parseInt(red[i].innerText)*1.8)+32)+"°";
            blue[i].innerText = Math.floor((parseInt(blue[i].innerText)*1.8)+32)+"°";
            
        }
        

    }

    if (elem.value == "°C"){
        for (var i=0; i<red.length; i++){
            red[i].innerText = Math.ceil((parseInt(red[i].innerText)-32)*0.5555)+"°";
            blue[i].innerText = Math.ceil((parseInt(blue[i].innerText)-32)*0.5555)+"°";
            
        }
        

    }

    

}