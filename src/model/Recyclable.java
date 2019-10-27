package model;

public class Recyclable extends Waste implements Usable{
	public final String PAPER = "paper";
	public final String CARDBOARD = "cardboard";
	public final String GLASS = "glass";
	public final String PLASTIC = "plastic";
	public final String METAL = "metal";
	private String kind;
	private String properDispo;
	
	
	
	public Recyclable(String id, String name, String origin, String color, double daysDecompose, String sourceProduct, String kind, String properDispo) {
		super(id, name, origin, color, daysDecompose, sourceProduct);
		this.kind = kind;
		this.properDispo = properDispo;
	}
	
	public void description() {
		if(!super.getOrigin().equalsIgnoreCase(HOME) || !super.getOrigin().equalsIgnoreCase(INDUSTRY) ) {
			this.properDispo = null;
		}
	}
	
	public String toString() {
		String msg = "";
		if(super.getOrigin().equalsIgnoreCase(HOME) || super.getOrigin().equalsIgnoreCase(INDUSTRY)) {
			msg = super.toString()+ " - [KIND OF WASTE]: " + kind + " - [DESCRIPTION FOR PROPER DISPOSITION]: " + properDispo;
		}
		else {
			msg = super.toString()+ " - [KIND OF WASTE]: " + kind;
		}
		
			
		return msg;
		
	}
	
	public double calculateHarmful() {
		double harmfulEffect= super.calculateHarmful() - super.calculateHarmful()*0.02;
		return harmfulEffect;
	}
	
	public String isUsable() {
		String msg = "";
		if(properDispo != null) {
			msg = "This waste is usable";
		}
		else {
			msg = "This waste is not usable";
		}
		return msg;
	}

}
