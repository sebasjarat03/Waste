package model;



public class Product {
	private String id;
	private String name;
	private String description;
	private Waste[] waste;
	
	public Product(String id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
		waste = new Waste[150];
		
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Waste[] getWaste() {
		
		return waste;
	}
	
	
	public String toString() {
		String msg = "[NAME]: " + name + " - [ID]: " + id + " - [DESCRIPTION]: " + description;
		return msg;
		
	}
	
	public void setWaste(Waste waste) {
		boolean inserted = false;
		for(int i = 0; i<this.waste.length && !inserted; i++){
			if(this.waste[i] == null){
				this.waste[i] = waste;
			}
		}
	}
	
	

}
