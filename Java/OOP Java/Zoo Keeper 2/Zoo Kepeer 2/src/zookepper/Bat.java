package zookepper;

public class Bat extends Mammal {
	public Bat() {
		this.setEnergyLevel(300);
	}
	public void fly() {
		System.out.println("Flaaayyy");
		this.setEnergyLevel(this.getEnergyLevel());
		System.out.println("Bat's energy is: "+ (this.getEnergyLevel()-50));
		this.setEnergyLevel(this.getEnergyLevel()-50);
	}
	
	public void eatHumans() {
		System.out.println("Yummyyyy");
		this.setEnergyLevel(this.getEnergyLevel());
		System.out.println("Bat's energy is: "+ (this.getEnergyLevel()+ 25));
		this.setEnergyLevel(this.getEnergyLevel()+25);
	}
	
	public void attackTown() {
		System.out.println("Heeeeelp, Firrre");
		this.setEnergyLevel(this.getEnergyLevel());
		System.out.println("Bat's energy is: "+ (this.getEnergyLevel() - 100));
		this.setEnergyLevel(this.getEnergyLevel() - 100);
		
	}
}
