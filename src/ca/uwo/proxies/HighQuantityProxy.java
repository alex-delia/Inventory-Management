package ca.uwo.proxies;

import java.util.Map;

import ca.uwo.client.Buyer;
import ca.uwo.client.Supplier;
import ca.uwo.frontend.Facade;

public class HighQuantityProxy extends Proxy{
	
	//highquantityproxy instance for singleton
	private static HighQuantityProxy instance;
	
	//singleton method for high quantity proxy
	public static HighQuantityProxy getInstance()
	{
		if(instance == null)
		{
			instance = new HighQuantityProxy();
		}
		
		return instance;
	}

	@Override
	//forwards the request proxy to the facade class
	public void placeOrder(Map<String, Integer> orderDetails, Buyer buyer) {
		Facade facade = Facade.getInstance();
		facade.placeOrder(orderDetails, buyer);
		
	}

	@Override
	public void restock(Map<String, Integer> restockDetails, Supplier supplier) {
		// TODO Auto-generated method stub
		
	}

}
