var number1;
var number2;
var operator;
var currentNumber = "";
var display = document.getElementById("display")



function press(number){
    currentNumber += parseFloat(number);  

    if(operator){
        number2 = parseFloat(currentNumber);
        

    }else{
        number1 = parseFloat(currentNumber);
    }
    display.innerText = currentNumber;


}




function setOP(op){
    operator = op;
    
    currentNumber = "";

    display.innerText = "0";



}

function clr(){
    
    number1=0;
    currentNumber=""
    number2=0;
    operator=undefined;
    
    display.innerText = "0";

}

function calculate(){
    var result;

    if(operator === "+"){
        result = number1 + number2;

    }else if (operator === "-"){
        result = number1 - number2;

    }else if(operator === "/"){
        result = number1 / number2;

    }else if (operator === "*"){
        result = number1 * number2;

    }

    clr()

    display.innerText = result;



}