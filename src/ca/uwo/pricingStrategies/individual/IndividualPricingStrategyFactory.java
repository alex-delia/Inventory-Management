package ca.uwo.pricingStrategies.individual;

import ca.uwo.pricingStrategies.aggregate.AggregateDefaultPricingStrategy;
import ca.uwo.pricingStrategies.aggregate.AggregatePricingStrategy;
import ca.uwo.pricingStrategies.aggregate.TestAggregatePricingStrategy;

public class IndividualPricingStrategyFactory {
	
	public static IndividualPricingStrategy create(String type) {
		switch(type) 
		{
			case "test":
				return new TestIndividualPricingStrategy();
			case "strategy1":
				return new IndividualPricingStrategy1();
			case "strategy2":
				return new IndividualPricingStrategy2();
			default:
				return new IndividualDefaultPricingStrategy();
		}
		
	}

}
