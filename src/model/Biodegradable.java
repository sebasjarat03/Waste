package model;

public class Biodegradable extends Waste implements Usable{
	private String ableComposting;

	public Biodegradable(String id, String name, String origin, String color, double daysDecompose,String sourceProduct, String ableComposting) {
		super(id, name, origin, color, daysDecompose, sourceProduct);
		this.ableComposting = ableComposting;
	}
	
	public String toString() {
		String msg = super.toString()+ " - [ABLE TO COMPOSE]: " + ableComposting;
		return msg;
		
	}
	
	public boolean turnToBool() {
		boolean able = false;
		if(ableComposting.equalsIgnoreCase("yes")) {
			able = true;
		}
		return able;
	}
	
	 public double calculateHarmful() {
		double harmfulEffect= super.calculateHarmful();
		if(turnToBool()) {
			harmfulEffect = super.calculateHarmful() - super.calculateHarmful()*0.01;
		}
		return harmfulEffect;
	}
	
	 public String isUsable() {
		 String msg = "";
		 if(super.getDays()<365 && turnToBool()) {
			 msg = "This waste is usable";
		 }
		 else {
			 msg = "This waste is not usable";
		 }
		 return msg;
	 }

}
