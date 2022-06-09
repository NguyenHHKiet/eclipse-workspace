package item.storage;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		int i=0;
		boolean exit = false;

		
		Services service = new Services();
		//-------------------------------------
		//Step 1: Input the number of Items
				System.out.println("Input the number of Items: ");
				Scanner sc = new Scanner(System.in);
				int n = sc.nextInt();
				ArrayDao dao = new ArrayDao();
				dao.setLength(n);
				for(int j = 0;j<n;j++) {
						service.add();}
					
//Nhap chuoi : add, search, delete
				int value;
				do {
					//Bang huong dan su dung
					System.out.println("=========================");
					System.out.println("1.Add list of items");
					System.out.println("2.Show list of items");
					System.out.println("3.Search 1 item (by ID)");
					System.out.println("4.Delete 1 item (by ID)");
					System.out.println("5.Exit");
					System.out.println("========================");
					System.out.println("Input value: ");
					value = sc.nextInt() ;
					switch(value) {
					case 1:
						service.add1();
						break;
					case 2:
						service.show();
						break;
					case 3:
						sc.nextLine();
						System.out.println("Input id (search): ");
						String id = sc.nextLine();
						Item tam = service.search(id);
						if (tam != null) {
							System.out.println("Found : " 
									+ tam.getID()+ " " + tam.getName()+ " " 
											+ tam.getUnitPrice()+ " " + tam.getQuantity());
						}	
						break;
					case 4:
						sc.nextLine();
						System.out.println("Input id (delete): ");
						String id1 = sc.nextLine();
						boolean result = service.delete(id1);
						if (result) {
							System.out.println("Successful !!");
							//service.show();
							break;
						}else {
							System.out.println("Fail !!");
							break;
						}
					case 5:
						sc.close();
						System.exit(0);
					}
				}while(value!=5);
				
// switch case: add => chay function add
		       
		
		
 //-------------------------------------------------------------------
  //Add items
//		//Step 1: Input the number of Items
//		System.out.println("Input the number of Items: ");
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		ArrayDao dao = new ArrayDao();
//		dao.setLength(n);
		
		//Step 2: add items
		
			
		//-------------------------------------
	//search
//		sc.nextLine();
//		System.out.println("Input id (search): ");
//		String id = sc.nextLine();
//		Item tam = service.search(id);
//		System.out.println("Found : " + tam.getID()+ " " + tam.getName()+ " " + tam.getUnitPrice()+ " " + tam.getQuantity());
		//-------------------------------------	
	//delete
//		sc.nextLine();
//		System.out.println("Input id (delete): ");
//		String id1 = sc.nextLine();
//		boolean result = service.delete(id1);
//		if (result) {
//			System.out.println("Successful !!");
//			service.show();
//		}else {
//			System.out.println("Fail !!");
//		}
		
//		service.show();
		
	}
}
