package ca.uwo.model.item.states;

import ca.uwo.model.Item;
import ca.uwo.utils.ItemResult;
import ca.uwo.utils.ResponseCode;

public class InStockState implements ItemState{

	@Override
	public ItemResult deplete(Item item, int quantity) {
		
		ItemResult itemResult;
		
		int availableQuantity = item.getAvailableQuantity();
		
		if (availableQuantity < quantity) {
			itemResult = new ItemResult("OUT OF STOCK", ResponseCode.Not_Completed);
			item.updateState(ItemStateFactory.create("outOfStock"));
			item.notifyViewers();
			
		} else {
			item.setAvailableQuantity(availableQuantity - quantity);
			if(item.getAvailableQuantity() < 10 && item.getAvailableQuantity() > 0)
			{
				item.updateState(ItemStateFactory.create("lowStock"));
				item.notifyViewers();
			}
			else if(item.getAvailableQuantity() == 0)
			{
				item.updateState(ItemStateFactory.create("outOfStock"));
				item.notifyViewers();
			}
			itemResult = new ItemResult("AVAILABLE", ResponseCode.Completed);
			
		}
		
		return itemResult;
	}

	@Override
	public ItemResult replenish(Item item, int quantity) {
		int availableQuantity = item.getAvailableQuantity();
		
		item.setAvailableQuantity(availableQuantity + quantity);

		ItemResult itemResult = new ItemResult("RESTOCKED", ResponseCode.Completed);
		
		return itemResult;
	}

}
