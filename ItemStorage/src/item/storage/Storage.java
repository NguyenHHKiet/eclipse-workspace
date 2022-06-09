package item.storage;

public interface Storage {
	public void show(); //	Show all items
	public void add();  //  Add 1 item
	public void search(String ID); // search 1 item (theo ID)
	public void delete();
}
