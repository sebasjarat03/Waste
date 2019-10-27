package model;

public class Recyclable extends Waste{
	public final String PAPER = "paper";
	public final String CARDBOARD = "cardboard";
	public final String GLASS = "glass";
	public final String PLASTIC = "plastic";
	public final String METAL = "metal";
	private String kind;
	
	public Recyclable(String id, String name, String origin, String color, double daysDecompose, String sourceProduct, String kind) {
		super(id, name, origin, color, daysDecompose, sourceProduct);
		this.kind = kind;
	}
	
	public String toString() {
		String msg = super.toString()+ " - [KIND OF WASTE]: " + kind;
		return msg;
		
	}
	
	public double calculateHarmful() {
		double harmfulEffect= super.calculateHarmful() - super.calculateHarmful()*0.02;
		return harmfulEffect;
	}

}
