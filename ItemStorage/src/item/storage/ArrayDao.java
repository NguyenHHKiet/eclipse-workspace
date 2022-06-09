package item.storage;

import java.util.Scanner;

public class ArrayDao {
	
		private static Item obj[];
		private static int length=100;
		
		int index = 0;
		static {
			obj = new Item[length];
		}
		
		//set ao
//		public void setArray() {
//			Item item = new Item("45","kh",12,45);
//			obj[0] = item;
//			obj[1] = item;
//		}
		
		public void setArray(Item item) {
//			for(int i=0; i<item.length; i++) {
//				obj[i] = item[i];
//			}
			if(index<length) {
				obj[index] = item;
				index++;
			}
		}
		
		public Item[] getArray(){
			return obj;
		}
		//------------------------------
		public static int getLength() {
			return length;
		}
		
		public static void setLength(int length1) {
			length = length1;
		}
		public static int reduceLength() {
			length--;
			return length;
		}
		
		public static int increaseLength() {
			length++;
			return length;
		}
		
//		public static void main(String[] args) {
//			
//		//Step 1: Add item to array
//			obj = new Item[2];
//			int i = 0;
//			Scanner sc = new Scanner(System.in);
//			do {
//				//Create 1 item
//				System.out.println("ID: ");
//				String ID = sc.nextLine();
//				System.out.println("Name: ");
//				String name = sc.nextLine();
//				System.out.println("Price: ");
//				Double price = sc.nextDouble();
//				System.out.println("Quantity: ");
//				int quantity = sc.nextInt();
//				sc.nextLine();
//				
//				Item item = new Item();
//				
//				item.setID(ID);
//				item.setName(name);
//				item.setUnitPrice(price);
//				item.setQuantity(quantity);
//				
//				//Add 1 item to array
//				obj[i] = item;
//				i++;
//							
//			
////				
//			}while(i<obj.length);
//			
//			sc.close();
//			
////			for(int j=0; j<obj.length;j++) {
////				System.out.println(obj[j].getID());
////				System.out.println(obj[j].getName());
////				System.out.println(obj[j].getUnitPrice());
////				System.out.println(obj[j].getQuantity());
////			}					
////		
//		
//		}
		
		
}
