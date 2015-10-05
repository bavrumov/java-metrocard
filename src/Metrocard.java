public class Metrocard {
	
	public static final double FARE=2.75,BONUS=1.11;
	private double currentValue, machineAdded=0;
	
	public Metrocard(double p) {
		currentValue=centRound(p);
	}
	
	public double getCurrentValue() {
		return currentValue;
	}
	
	public void setCurrentValue(double a) {
		this.currentValue = centRound(a);
	}
	
	public double getmachineAdded() {
		return machineAdded;
	}
	
	public int currentRides() {
		return (int)(currentValue/FARE);
	}
	
	public double addValue(double a) {
		a=Math.round(a*100)/100.0;
		currentValue+=a;
		return a;
	}
	
	public double removeValue(double a) {
		a=Math.round(a*100)/100.0;
		currentValue-=a;
		return a;
	}
	
	public void addRides(int r) {
		this.addValue(r*FARE);
	}
	
	public void removeRides(int r) {
		this.removeValue(r*FARE);
	}

	public double addMoney(double a) {
		if (a>=5.5)
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
	
	private static double centRound(double a) {
		return Math.round(a*100)/100.0;
	}
}