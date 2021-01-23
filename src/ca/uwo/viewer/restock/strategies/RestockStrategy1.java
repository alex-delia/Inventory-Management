package ca.uwo.viewer.restock.strategies;

public class RestockStrategy1 implements RestockStrategy{

	@Override
	public int calculateQuantity(String itemName, int quantity, double price) {
		//quantity to restock by, we choose 10 as this strategy (could be 50 but we have units50strategy)
		int restockBy = 10;
		
		
		//return quantity to restock
		return restockBy;
	}

}
