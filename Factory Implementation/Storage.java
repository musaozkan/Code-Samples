// Musa Özkan 150121058 

import java.util.Arrays;

public class Storage {
	private int capacity;
	private Item[] items;

	public Storage(int capacity) {
		this.capacity = capacity;
	}

	public void addItem(Item item) {
		if(items == null) {
			items = new Item[1];
			items[0] = item;
		}
		else {
			items = Arrays.copyOf(items, items.length + 1);
	        items[items.length-1] = item;
		}
	}
}
