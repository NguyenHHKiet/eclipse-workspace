package item.storage;

public class Item {
	private String ID;
	private String name;
	private int unitPrice;
	private int quantity;
	
	
	//Constructor
	public Item() {
		this.ID = null;
		this.name = null;
		this.unitPrice = 0;
		this.quantity = 0;
	}


	public Item(String iD, String name, int unitPrice, int quantity) {
		super();
		this.ID = iD;
		this.name = name;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}


	public String getID() {
		return ID;
	}


	public void setID(String iD) {
		this.ID = iD;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getUnitPrice() {
		return unitPrice;
	}


	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	
	
	

	
	
}
