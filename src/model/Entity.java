package model;

public class Entity {
	public final int MAX = 1000;
	private Waste[] waste;
	private Product[] product;
	
	public Entity() {
		waste = new Waste[MAX];
		product = new Product[MAX];
	}
	
	//search methods
	public Waste searchWaste(String name) {
		Waste temp = null;
		boolean found = false;
		for (int i = 0; i<waste.length && !found; i++) {
			if(waste[i] != null) {
				if(waste[i].getName().equalsIgnoreCase(name)) {
					temp = waste[i];
					found = true;
				}
			}
		}
		return temp;
	}
	
	public Product searchProduct(String id) {
		Product temp = null;
		boolean found = false;
		for (int i = 0; i<product.length && !found; i++) {
			if(product[i] != null) {
				if(product[i].getId().equalsIgnoreCase(id)) {
					temp = product[i];
					found = true;
				}
			}
		}
		return temp;
	}
	//end of search methods
	
	//add waste methods
	
	public String addWasteB(String id, String name, String origin, String color, double daysDecompose, String sourceProduct, String ableComposting) {
		String msg = "";
		if(searchWaste(name)!=null && searchWaste(name).getName().equalsIgnoreCase(name)) {
			msg += "\n*Error: The name is already in use";
		}
		if(searchWaste(name)!=null && searchWaste(name).getId().equalsIgnoreCase(id)) {
			msg += "\n*Error: The waste's id is already registered";
		}
		if(searchProduct(sourceProduct) == null) {
			msg += "\n*Missing product, please create it";
		}
		if(msg.equalsIgnoreCase("")) {
			boolean inserted = false;
			for(int i = 0; i<waste.length && !inserted; i++) {
				if(waste[i] == null) {
					waste[i] = new Biodegradable (id, name, origin, color, daysDecompose, sourceProduct, ableComposting);
					inserted = true;
					waste[i].setProduct(searchProduct(sourceProduct));
					searchProduct(sourceProduct).setWaste(waste[i]);
					msg += "\n**[WASTE CREATED SUCCESSFULLY]**";
				}
			}
			
		}
		return msg;
	}
	
	public String addWasteI(String id, String name, String origin, String color, double daysDecompose, String sourceProduct, String advice) {
		String msg = "";
		if(searchWaste(name)!=null && searchWaste(name).getName().equalsIgnoreCase(name)) {
			msg += "\n*Error: The name is already in use";
		}
		if(searchWaste(name)!=null && searchWaste(name).getId().equalsIgnoreCase(id)) {
			msg += "\n*Error: The waste's id is already registered";
		}
		if(  searchProduct(sourceProduct) == null) {
			msg += "\n*Missing product, please create it";
		}
		if(msg.equalsIgnoreCase("")) {
			boolean inserted = false;
			for(int i = 0; i<waste.length && !inserted; i++) {
				if(waste[i] == null) {
					waste[i] = new Inert (id, name, origin, color, daysDecompose, sourceProduct, advice);
					inserted = true;
					waste[i].setProduct(searchProduct(sourceProduct));
					searchProduct(sourceProduct).setWaste(waste[i]);
					msg = "\n**[WASTE CREATED SUCCESSFULLY]**";
				}
			}
		}
		return msg;
	}
	
	
	
	public String addWasteR(String id, String name, String origin, String color, double daysDecompose, String sourceProduct, String kind, String properDispo) {
		String msg = "";
		if(searchWaste(name)!=null && searchWaste(name).getName().equalsIgnoreCase(name)) {
			msg += "\n*Error: The name is already in use";
		}
		if(searchWaste(name)!=null && searchWaste(name).getId().equalsIgnoreCase(id)) {
			msg += "\n*Error: The waste's id is already registered";
		}
		if(searchProduct(sourceProduct) == null) {
			msg += "\n*Missing product, please create it";
		}
		if(msg.equalsIgnoreCase("") && searchProduct(sourceProduct)!=null) {
			boolean inserted = false;
			for(int i = 0; i<waste.length && !inserted; i++) {
				if(waste[i] == null) {
					waste[i] = new Recyclable (id, name, origin, color, daysDecompose, sourceProduct, kind, properDispo);
					inserted = true;
					waste[i].setProduct(searchProduct(sourceProduct));
					searchProduct(sourceProduct).setWaste(waste[i]);
					msg = "\n**[WASTE CREATED SUCCESSFULLY]**";
				}
			}
		}
		return msg;
	}
	
	//end of add waste methods
	
	public String addProduct(String id, String name, String description) {
		String msg = "";
		if(searchProduct(id)!=null && searchProduct(id).getName().equalsIgnoreCase(name)) {
			msg += "\n*Error: The name is already in use";
		}
		if(searchProduct(id)!=null && searchProduct(id).getId().equalsIgnoreCase(id)) {
			msg += "\n*Error: the product's id is already registered";
		}
		if(msg.equalsIgnoreCase("")) {
			boolean inserted = false;
			for(int i = 0; i<product.length && !inserted; i++) {
				if(product[i]==null) {
					product[i]= new Product(id, name, description);
					inserted = true;
					msg = "\n**[PRODUCT CREATED SUCCESSFULLY]**";
				}
			}
		}
		return msg;
	}
	
	public String showWasteReport() {
		String msg = "";
		for(int i = 0; i<waste.length; i++) {
			if(waste[i] != null) {
				
				if(waste[i] instanceof Biodegradable) {
					Biodegradable bmirror = (Biodegradable)waste[i];
					msg += "\n(BIODEGRADABLE) " + bmirror.toString();
				}
				
				if(waste[i] instanceof Inert) {
					Inert imirror = (Inert) waste[i];
					msg += "\n(INERT) " +imirror.toString();
				}
				
				if(waste[i] instanceof Recyclable) {
					Recyclable rmirror = (Recyclable) waste[i];
					msg += "\n(RECYCLABLE) " + rmirror.toString();
				}
			}
		}
		return msg;
	}
	
	public String showInfo(String info) {
		
		String msg = "";
		for(int i = 0; i<waste.length ; i++) {
			if(waste[i] != null ) {
				if(waste[i].getName().equalsIgnoreCase(info) || waste[i].getSourceProduct().equalsIgnoreCase(info) ) {
					msg += "\n" + waste[i].toString();
					
				}
			}
		}
		
		return msg;
	}
	
	public String showProducts() {
		String msg = "";
		for(int i = 0; i<product.length; i++) {
			if(product[i] != null) {
				msg+= "\n" + product[i].toString();
			}
		}
		return msg;
	}
	
	
	public String calculateHarmful(String id) {
		String harmfulEff = "";
		for(int i = 0; i<waste.length; i++) {
			if(waste[i] != null) {
				if(waste[i].getId().equalsIgnoreCase(id)) {
					harmfulEff = "\nThe harmful effect is= " + "[" + waste[i].calculateHarmful() + "]";
				}
				else {
					harmfulEff = "\nWaste not found";
				}
			}
		}
		return harmfulEff;
	}
	
	public String showUsable(String id) {
		String msg = "";
		boolean found = false;
		for(int i = 0; i<waste.length && !found; i++) {
			if(waste[i] != null) {
				if(waste[i].getId().equalsIgnoreCase(id)) {
					if(waste[i] instanceof Biodegradable ) {
						Biodegradable mirror = (Biodegradable) waste[i];
						msg = mirror.isUsable();
						found = true;
					}
					if(waste[i] instanceof Recyclable) {
						Recyclable mirror = (Recyclable) waste[i];
						msg = mirror.isUsable();
						found = true;
					}
				}
				else {
					msg = "Waste not found";
				}
			}
		}
		return msg;
	}
	
	

}
