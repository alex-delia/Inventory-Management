package ca.uwo.viewer.restock.strategies;

//this class is in case a strategy is not specified it is the default restock strategy we set to restock by 25
public class RestockDefaultStrategy implements RestockStrategy{

	@Override
	public int calculateQuantity(String itemName, int quantity, double price) {
		//default restock 25 items
		return 25;
	}

}
