package zookepper;

public class Mammal {
	private int energyLevel = 100;
	public int displayEnergy() {
		return this.energyLevel;
	}
	
	public int getEnergyLevel() {
		return energyLevel;
	}
	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}
}
