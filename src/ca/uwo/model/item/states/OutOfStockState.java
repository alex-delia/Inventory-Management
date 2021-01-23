package ca.uwo.model.item.states;

import ca.uwo.model.Item;
import ca.uwo.utils.ItemResult;
import ca.uwo.utils.ResponseCode;

public class OutOfStockState implements ItemState{

	@Override
	public ItemResult deplete(Item item, int quantity) {
		ItemResult itemResult;
		
		int availableQuantity = item.getAvailableQuantity();
		
		itemResult = new ItemResult("OUT OF STOCK", ResponseCode.Not_Completed);
		
		return itemResult;

		
	}

	@Override
	public ItemResult replenish(Item item, int quantity) {
		int availableQuantity = item.getAvailableQuantity();
		
		item.setAvailableQuantity(availableQuantity + quantity);

		if(item.getAvailableQuantity() > 10)
		{
			item.updateState(ItemStateFactory.create("inStock"));
		}
		else
		{
			item.updateState(ItemStateFactory.create("lowStock"));
		}
		
		ItemResult itemResult = new ItemResult("RESTOCKED", ResponseCode.Completed);
		
		return itemResult;
	}

}
