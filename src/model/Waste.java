package model;

public abstract class Waste {
	public final String HOME = "home";
	public final String INDUSTRY = "industry";
	public final String MUNICIPAL = "municipal";
	public final String BUILDING = "building";
	public final String HOSPITAL = "hospital";
	public final double HARMHOME = 0.05;
	public final double HARMINDUSTRY = 0.1;
	public final double HARMMUNICIPAL = 0.12;
	public final double HARMBUILDING = 0.08;
	public final double HARMHOSPITAL = 0.15;
	private String id;
	private String name;
	private String origin;
	private String color;
	private double daysDecompose;
	private String sourceProduct;
	private Product product;
	
	public Waste(String id, String name, String origin, String color, double daysDecompose, String sourceProduct) {
		
		this.id = id;
		this.name = name;
		this.origin = origin;
		this.color = color;
		this.daysDecompose = daysDecompose;
		this.sourceProduct = sourceProduct;
		
	}
	
	public double calculateHarmful() {
		double harmfulEffect = 0;
		if(origin.equalsIgnoreCase(HOME)) {
			harmfulEffect = daysDecompose * HARMHOME;
		}
		if(origin.equalsIgnoreCase(INDUSTRY)) {
			harmfulEffect = daysDecompose * HARMINDUSTRY;
		}
		if(origin.equalsIgnoreCase(MUNICIPAL)) {
			harmfulEffect = daysDecompose * HARMMUNICIPAL;
		}
		if(origin.equalsIgnoreCase(BUILDING)) {
			harmfulEffect = daysDecompose * HARMBUILDING;
		}
		if(origin.equalsIgnoreCase(HOSPITAL)) {
			harmfulEffect = daysDecompose * HARMHOSPITAL;
		}
		return harmfulEffect;
	}
	
	
	public String getName() {
		return name;
	}
	
	public String getId() {
		return id;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public String toString() {
		String msg = " [NAME]: " + name + " - [ID]: " + id + " - [ORIGIN]: " + origin + " - [COLOR]: " + color + " - [DAYS OF DECOMPOSITION]: " + daysDecompose + " - [SOURCE PRODUCT]: " + product.toString();
		return msg;
	}
	
	public String getSourceProduct() {
		return sourceProduct;
	}

}
