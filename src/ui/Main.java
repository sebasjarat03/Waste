package ui;
import model.*;
import java.util.*;

public class Main {
	private Scanner scs;
	private Scanner sci;
	private Entity entity;
	
	public static void main(String args[]) {
		Main main = new Main();
		main.menu();
	}
	
	public Main() {
		scs = new Scanner(System.in);
		sci = new Scanner(System.in);
		entity = new Entity();
		
	}
	
	public void menu() {
		int select = 0;
		while(select != 10) {
			System.out.println("\nWelcome! \nSelect an option:\n");
			System.out.println("1) Add a waste 		\n2) Show wastes reports 		\n3) Add a product");
			System.out.println("4) Search waste info by its name or by its product's id    \n5) Show list of products \n6) Calculate the waste's harmful effect");
			System.out.println("7) Check if a biodegradable or recyclable waste is usable  \n8) Show the wastes of a product from most harmful to less \n9) Exit");
			select = sci.nextInt();
			
			switch(select) {
			case 1:
				System.out.println(addWaste());
				break;
			case 2:
				System.out.println(entity.showWasteReport());
				break;
			case 3:
				System.out.println(addProduct());
				break;
			case 4:
				System.out.print("Enter the name of the waste or the id of its source product: "); String info = scs.nextLine();
				System.out.println(entity.showInfo(info));
				break;
			case 5:
				System.out.println(entity.showProducts());
				break;
			case 6:
				System.out.print("Enter the id of the waste to calculate its harmful effect: "); String id = scs.nextLine();
				System.out.println(entity.calculateHarmful(id));
				break;
			case 7:
				System.out.print("Enter the id of the waste to see if is usable: "); String idw = scs.nextLine();
				System.out.println(entity.showUsable(idw));
				break;
			case 8:
				System.out.print("Enter the id of the product that you want to see its wastes: "); String idp = scs.nextLine();
				System.out.println(entity.organizedWastes(idp));
				break;
			
			}
		}
	}
	
	public String addWaste() {
		String msg = "";
		System.out.print("Enter the id of the waste: "); String id = scs.nextLine();
		System.out.print("Enter the name of the waste: "); String name = scs.nextLine();
		System.out.print("Enter the origin of the waste(home, industry, municipal, building, hospital): "); String origin = scs.nextLine();
		System.out.print("Enter the color of the waste: "); String color = scs.nextLine();
		System.out.print("Enter the number of days of decomposition of the waste: "); double daysDecompose = sci.nextDouble();
		System.out.print("Enter the id of the product that produces this waste: "); String sourceProduct = scs.nextLine();
		System.out.print("Enter the type of waste: "); String type = scs.nextLine();
		
		
		switch(type.toLowerCase()) {
		case "biodegradable":
			System.out.print("Is the waste able to composting?(yes/no): "); String ableComposting = scs.nextLine();
			msg = entity.addWasteB(id, name, origin, color, daysDecompose, sourceProduct, ableComposting);
			break;
		case "inert":
			System.out.print("Add an advice to reduce the use of this wastes: "); String advice = scs.nextLine();
			msg = entity.addWasteI(id, name, origin, color, daysDecompose, sourceProduct, advice);
			break;
		case "recyclable":
			System.out.print("Enter the kind of this waste(paper, cardboard, glass, plastic, metal): "); String kind = scs.nextLine();
			if(origin.equalsIgnoreCase("home") || origin.equalsIgnoreCase("industry")) {
				System.out.print("Enter a description for the proper disposition: "); String properDispo = scs.nextLine();
				msg = entity.addWasteR(id, name, origin, color, daysDecompose, sourceProduct, kind,properDispo);
			}
			else {
				String properDispo = null;
				msg = entity.addWasteR(id, name, origin, color, daysDecompose, sourceProduct, kind,properDispo);
			}
			
			break;
		default: 
			System.out.println("This type of waste doesn't exists");
			break;
		}
		return msg;
	}
	
	public String addProduct() {
		System.out.print("Enter the id of the product: "); String id = scs.nextLine();
		System.out.print("Enter the name of the product: "); String name = scs.nextLine();
		System.out.print("Enter the description of the product: "); String description = scs.nextLine();
		return entity.addProduct(id, name, description);
	}

}
