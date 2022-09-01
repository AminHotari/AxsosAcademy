function pizzaOven(crustType,sauceType,cheeses,toppings){
    var pizza={}
    pizza.crustType=crustType
    pizza.sauceType=sauceType
    pizza.cheeses=cheeses
    pizza.toppings=toppings

    return pizza

}

var pizza1 = pizzaOven ("deep dish","traditional",["mozzarella"],["pepperoni","sausage"])
console.log(pizza1);

var pizza2 = pizzaOven ("hand tossed","marinara",["mozzarella", "feta"],["mushrooms", "olives", "onions"])
console.log(pizza2);

var pizza3 = pizzaOven ("hand tossed","marinara",["mozzarella", "feta"],"white cheese")
console.log(pizza3);

var pizza4 = pizzaOven ("hand tossed","marinara",["mozzarella", "feta"],"green olive")
console.log(pizza4);



function randomPizza(){
    var pizza={}
    pizza.crustType=
    pizza.sauceType=
    pizza.cheeses=
    pizza.toppings=


    return pizza

}
