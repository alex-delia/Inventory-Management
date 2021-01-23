package ca.uwo.viewer.restock.strategies;

public class Units50RestockStrategy implements RestockStrategy{

	@Override
	public int calculateQuantity(String itemName, int quantity, double price) {

		return 50;
	}

}
