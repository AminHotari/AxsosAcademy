class Card{
    constructor(name, cost){
        this.name = name;
        this.cost = cost;
    }
} 
class Unit extends Card{
    constructor(name, cost, power, resilience){
        super(name, cost);
        this.power = power;
        this.resilience = resilience;
    }
    attack(target){
        target.resilience -= this.power
    }

}

const RedBeltNinja = new Unit("Red Belt Ninja", 3, 3, 4);
const BlackBeltNinja = new Unit("Black Belt Ninja", 4, 5, 4);

class Effect extends Card{
    constructor(name, cost, text, stat, magnitude){
        super(name, cost);
        this.text = text;
        this.stat = stat;
        this.magnitude = magnitude;
    }

    play( target ) {
        if( target instanceof Unit ) {
            if(this.stat == "resilience"){
                target.resilience += this.magnitude
            }
            else{
                target.power += this.magnitude
            }
        } 
        else {
            throw new Error( "Target must be a unit!" );
        }
    }
}

const Hard = new Effect("Hard Algorithm", 2, "increase targets resilience by 3", "resilience", 3);
const Promis = new Effect("Unhandled Promise Rejection", 1, "reduce targets resilience by 2", "resilience", -2);
const Pair = new Effect("Pair Programming", 3, "increase targets resilience by 2", "power", 2);

Hard.play(RedBeltNinja)
console.log(RedBeltNinja.resilience)

Promis.play(RedBeltNinja)
console.log(RedBeltNinja.resilience)

Pair.play(RedBeltNinja)
console.log(RedBeltNinja.power)

RedBeltNinja.attack(BlackBeltNinja)
console.log(BlackBeltNinja.resilience)

    