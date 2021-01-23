package ca.uwo.viewer.restock.strategies;


public class WeirdRestockStrategy implements RestockStrategy{

	@Override
	public int calculateQuantity(String itemName, int quantity, double price) {

		switch(itemName) {
		case "apple":
			return 500;
		default:
			int restockQuantity = (int) (2*(quantity+1)*price);
			return restockQuantity;
		}
	}

}
