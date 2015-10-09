public class Metrocard {
	
	public static final double FARE=2.75,BONUS=1.11;
	private double currentValue, machineAdded=0;
	
	public Metrocard(double p) {
		currentValue=centRound(p);
	}
	
	public double getCurrentValue() {
		return currentValue;
	}
	
	private void setCurrentValue(double a) {
		this.currentValue = centRound(a);
	}
	
	public double getmachineAdded() {
		return machineAdded;
	}
	
	public int currentRides() {
		return (int)(currentValue/FARE);
	}
	
	public void addValue(double a) {
		currentValue+=centRound(a);
	}
	
	public void removeValue(double a) {
		currentValue-=centRound(a);
	}
	
	public void addRides(int r) {
		this.addValue(r*FARE);
	}
	
	public void removeRides(int r) {
		this.removeValue(r*FARE);
	}

	public double addMoney(double a) {
		if (a>=2*FARE)
			a*=BONUS;
		machineAdded=centRound(a);
		currentValue+=machineAdded;
		return machineAdded;
	}

	public void undo() {
		this.removeValue(machineAdded);
	}

	public double remainder() {
		return centRound(currentValue%FARE);
	}
	
	public static double centRound(double a) {
		return Math.round(a*100)/100.0;
	}
	
}