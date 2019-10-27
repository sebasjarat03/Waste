package model;

public class Inert extends Waste {
	private String advice;
	
	public Inert(String id, String name, String origin, String color, double daysDecompose, String sourceProduct, String advice) {
		super(id, name, origin, color, daysDecompose, sourceProduct);
		this.advice = advice;
	}
	
	public String toString() {
		String msg = super.toString()+ " - [ADVICE TO REDUCE ITS USE]: " + advice;
		return msg;
		
	}

}
