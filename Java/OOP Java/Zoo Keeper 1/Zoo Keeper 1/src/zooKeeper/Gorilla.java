package zooKeeper;

public class Gorilla extends Mammal {
	public void throwSomething() {
		System.out.println("throwwww");
		int energy = this.getEnergyLevel();
		this.setEnergyLevel(energy - 5);
		System.out.println("Gorilla's energy is: "+ (energy - 5));
	}
	
	public void eatBananas() {
		System.out.println("Yammyy");
		int energy = this.getEnergyLevel();
		energy += 10;
		System.out.println("Gorilla's energy is: "+ energy);
	}
	
	public void climb() {
		System.out.println("Climb");
		int energy = this.getEnergyLevel();
		energy -= 10;
		System.out.println("Gorilla's energy is: "+ energy);
		
	}
}
