package ca.uwo.model.item.states;

public class ItemStateFactory {
	
	public static ItemState create(String type)
	{
		switch(type)
		{
			case "inStock":
				return new InStockState();
			case "lowStock":
				return new LowStockState();
			case "outOfStock":
				return new OutOfStockState();
			default:
				return new OutOfStockState();
		}
	}

}
