package ca.uwo.viewer.restock.strategies;

import ca.uwo.pricingStrategies.individual.IndividualDefaultPricingStrategy;
import ca.uwo.pricingStrategies.individual.TestIndividualPricingStrategy;

public class RestockStrategyFactory {
	
	public static RestockStrategy create(String type) 
	{
		switch(type) {
			case "strategy1":
				return new RestockStrategy1();
			case "strategy2":
				return new RestockStrategy2();
			case "50":
				return new Units50RestockStrategy();
			case "weird":
				return new WeirdRestockStrategy();
			default:
				return new RestockDefaultStrategy();
			}
		
	}
}
