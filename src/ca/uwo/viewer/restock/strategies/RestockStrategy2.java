package ca.uwo.viewer.restock.strategies;

public class RestockStrategy2 implements RestockStrategy{

	@Override
	public int calculateQuantity(String itemName, int quantity, double price) {

		switch(itemName) 
		{
			//if the item is apples restock by 100, otherwise restock by 25
			case "apple":
				return 100;
			default:
				return 25;
		}
	}

}
