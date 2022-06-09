package item.storage;

import java.util.Scanner;


public class Services {
	private static Scanner sc;
	private static ArrayDao dao;
	static {
		dao = new ArrayDao();
	}
	public static void add() {
//		dao.init();
		Item item = new Item();
		sc = new Scanner(System.in);
		
		
		System.out.println(" ID : ");
		String id = sc.nextLine();
		
		System.out.println(" Name : ");
		String name = sc.nextLine();
		
		int unitP = 0;
		do {
			System.out.println(" unitPrice : ");
			while(!sc.hasNextInt()) { // Not a integer
				System.out.println("That is not a integer");
				sc.next();
				System.out.println(" unitPrice : ");
			}
			unitP = sc.nextInt();
		}while(unitP <= 0);
		
		int quan = 0;
		do {
			System.out.println(" Quantity : ");
			while(!sc.hasNextInt()) { // Not a integer
				System.out.println("That is not a integer");
				sc.next();
				System.out.println(" Quantity : ");
			}
			quan = sc.nextInt();
		}while(quan <= 0);
		
		sc.nextLine();
		
		item.setID(id);
		item.setName(name);
		item.setUnitPrice(unitP);
		item.setQuantity(quan);
		
		dao.setArray(item);
		
		
		
//		System.out.println(dao.getArray()[0].getID());

	}
	
	public static void show() {
//		System.out.println(dao.getLength());
		for(int i = 0 ; i < dao.getLength(); i++) {
			System.out.println(dao.getArray()[i].getID());
			System.out.println(dao.getArray()[i].getName());
			System.out.println(dao.getArray()[i].getUnitPrice());
			System.out.println(dao.getArray()[i].getQuantity());
		}
	}
	
	public static Item search(String id) {
		Item tam = null;
		
		for(int i = 0; i < dao.getLength(); i++) {
			if(dao.getArray()[i] != null) {
				if(dao.getArray()[i].getID().equals(id)) {
					tam = dao.getArray()[i];
					break;
				}
				else {
					System.out.println("Not found");
					break;
				}
			}
		}
		return tam;
	}
	
	public static Boolean delete(String id) {
		boolean status = false;
		int flag = 0;
		int findIndex = -1; 
		
		for(int i = 0; i < dao.getLength(); i++) {
			if(dao.getArray()[i] != null) {
				if(dao.getArray()[i].getID().equals(id)) {
					flag = 1; // bao la da tim duoc
					findIndex = i;
					status = true;
				}				
			}	
		}
		
		if(flag == 1 ) {
			for(int i = findIndex; i<dao.getLength()-1; i++) {
				dao.getArray()[i] = dao.getArray()[i+1];
			}
			
			dao.reduceLength();
		}
		return status;
	}
	
	public static void add1() {
//		dao.init();
		Item item = new Item();
		sc = new Scanner(System.in);
		
		dao.increaseLength();
		
		System.out.println(" ID : ");
		String id = sc.nextLine();
		
		System.out.println(" Name : ");
		String name = sc.nextLine();
		
//		System.out.println(" unitPrice : ");
		int unitP = 0;
		do {
			System.out.println(" unitPrice : ");
			while(!sc.hasNextInt()) { // Not a integer
				System.out.println("That is not a integer");
				sc.next();
				System.out.println(" unitPrice : ");
			}
			unitP = sc.nextInt();
		}while(unitP <= 0);
		
		int quan = 0;
		do {
			System.out.println(" Quantity : ");
			while(!sc.hasNextInt()) { // Not a integer
				System.out.println("That is not a integer");
				sc.next();
				System.out.println(" Quantity : ");
			}
			quan = sc.nextInt();
		}while(quan <= 0);
		
		sc.nextLine();
		
		item.setID(id);
		item.setName(name);
		item.setUnitPrice(unitP);
		item.setQuantity(quan);
		
		dao.setArray(item);
		
		
		
//		System.out.println(dao.getArray()[0].getID());

	}
	
}
