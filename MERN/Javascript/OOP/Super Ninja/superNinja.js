class Ninja {
    constructor (name, health){
        this.name = name;
        this.health = health;
        this.speed = 3;
        this.strength = 3;
    }

    sayName(){
        console.log(this.name);
    }

    showStats(){
        console.log(this.name, this.strength, this.speed, this.health);
    }

    drinkSake(){
        console.log(this.health += 10);
    }
}


class Sensei extends Ninja {
    constructor(name){
        super(name);
        this.health = 200;
        this.speed = 10;
        this.strength = 10;
        this.wisdom = 10;
    }

    speakWisdom(){
        const message = super.drinkSake();
        // console.log(message);
    }
}

const superSensei = new Sensei("Amin");
superSensei.speakWisdom();
console.log(superSensei.name);
console.log(superSensei.wisdom);
console.log("Name: "+ superSensei.name +", Health: "+superSensei.health +", Speed: " +superSensei.speed+ ", Strength: "+superSensei.strength );
superSensei.showStats();
