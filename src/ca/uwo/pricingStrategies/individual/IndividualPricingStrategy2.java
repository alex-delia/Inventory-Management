package ca.uwo.pricingStrategies.individual;

public class IndividualPricingStrategy2 implements IndividualPricingStrategy {

	@Override
	public double calculate(int quantity, double price) {
		
		//calculate the price of the items
		double total = price*quantity;
		
		//with larger than 100 quantity of an item we apply a 10% discount
		if(quantity > 100)
		{
			total = total *0.9;
		}
		//case where we add 10 % for a lower quantity of item order
		else if (quantity < 5)
		{
			total = total * 1.1;
		}
		
		//return the calculated price
		return total;
	}

}
