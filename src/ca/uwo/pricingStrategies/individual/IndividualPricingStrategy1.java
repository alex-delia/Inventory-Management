package ca.uwo.pricingStrategies.individual;

public class IndividualPricingStrategy1 implements IndividualPricingStrategy {

	@Override
	public double calculate(int quantity, double price) {
		
		//this strategy returns the price as the product of quantity and price
		return quantity*price;
	}

}
