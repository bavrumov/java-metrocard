public class FareCalculator {
	
	public static final double FARE=Metrocard.FARE,BONUS=Metrocard.BONUS;
	private Metrocard c;
	
	public FareCalculator(Metrocard myCard) {
		c=myCard;
	}
	
	public FareCalculator(double init) {
		this(new Metrocard(init));
	}
	
	public double addXRides(int x) {
		return howMuchtoAdd(Metrocard.centRound(x*FARE));
	}
	
	public double totalXRides(int x) {
		return howMuchtoAdd(Metrocard.centRound(neededRideValue(x)));
	}
	
	public double uptoXMoney(double m) {
		return addXRides((int)Math.floor((c.getCurrentValue()+Metrocard.centRound(m*BONUS))/FARE));
	}
	
	public double neededRideValue(int r) {
		if (r*FARE>c.getCurrentValue())
			return Metrocard.centRound(r*FARE-c.getCurrentValue());
		return 0;
	}
	
	public double howMuchtoAdd(double desiredValue) {
		double toAdd;
		if (desiredValue<2*FARE*BONUS) //$6.105
			toAdd=desiredValue;
		else
			toAdd=desiredValue/BONUS;
		return Math.ceil(toAdd*20)/20;
	}
	
}