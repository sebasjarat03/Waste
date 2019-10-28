package model;

import java.util.Arrays;

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
		boolean found = false;
		String harmfulEff = "";
		for(int i = 0; i<waste.length && !found; i++) {
			if(waste[i] != null) {
				if(waste[i].getId().equalsIgnoreCase(id)) {
					harmfulEff = "\nThe harmful effect is= " + "[" + waste[i].calculateHarmful() + "]";
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
	
	/**public Waste[] getNotNullWastes(Waste[] wastes_with_null_positions){
        // Count how many positions aren't null
        int num_of_not_null_positions = 0;
        for(Waste waste: wastes_with_null_positions){
            num_of_not_null_positions += (waste != null) ? 1 : 0; 
        }
        
        // Intiialize clean waste array
        Waste[] clean_array = new Waste[num_of_not_null_positions];
        int j= 0; // Counter for clean array
        for(int i = 0; i < wastes_with_null_positions.length; i++){
            if(wastes_with_null_positions[i] != null){
                clean_array[j] = wastes_with_null_positions[i];
                j++;
            }
        }
        System.out.println(Arrays.toString(clean_array));
        return clean_array;
    }*/

	
	/**public Waste[] bubble(Waste[] array)
    {
      Waste mirror;
      Waste[] organizedArray;
      for(int i = 1; i < (array.length-1); i++)
      {
        for(int j = 0;j < (array.length-1);j++)
        {
          if(array[j].calculateHarmful() < array[j+1].calculateHarmful())
          {
            mirror = array[j];
            array[j] = array[j+1];
            array[j+1] = mirror;
          }   
        }
      }
      organizedArray = array;
      return organizedArray;
    }*/
	/**public static Waste[] bubble(Waste[] array) {
        Waste temp;
        for(int i = 0; i < array.length; i++){
          for(int j = i +1; j<array.length; j++){
            if(array[i].calculateHarmful() > array[j].calculateHarmful()){
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
          }
        }
        return array;
      }*/
	
	public Waste[] searchId(String id) {
		int count = 0;
		for (int i = 0; i < waste.length; i++) {
			if(waste[i] != null) {
			if(waste[i].getSourceProduct() == id) {
				count++;
			}
			}
		}
		
		
		
		Waste[] list = new Waste[count];
		
		for (int i = 0; i < waste.length; i++) {
			if(waste[i] != null) {
			if(waste[i].getSourceProduct() == id) {
				list[i] = waste[i];
			}
			}
		}
		
		if(count >= 2) {
		
		Waste temp;
        for(int i=1;i < list.length;i++){
            for (int j=0 ; j < list.length- 1; j++){
                if (list[j].calculateHarmful() < list[j+1].calculateHarmful()){
                    temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                }
            }
        }
    
	}
		
		return list;
	}
	
	public String organizedWastes(String id) {
		String msg = "";
		for(int i = 0; i<product.length; i++) {
			if(product[i] != null) {
				if(product[i].getId().equalsIgnoreCase(id)) {
				 Waste[] sorted_wastes = searchId(id);
					
					for(int j = 0; j<sorted_wastes.length; j++) {
						
						msg += "\n" + sorted_wastes[j].getName() + "  " + sorted_wastes[j].calculateHarmful();
						
					}
				}
			}
		}
		return msg;
	}

}
