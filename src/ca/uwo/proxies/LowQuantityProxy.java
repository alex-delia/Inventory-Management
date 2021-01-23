package ca.uwo.proxies;

import java.util.Map;
import java.util.Map.Entry;

import ca.uwo.client.Buyer;
import ca.uwo.client.Supplier;
import ca.uwo.frontend.Facade;
import ca.uwo.utils.OrderItem;

public class LowQuantityProxy extends Proxy{
	
	//this is the only instance of the low quantity proxy to implement the singleton design
	private static LowQuantityProxy instance;
	
	//next Proxy in the chain of responsibility
	private static Proxy next;
	
	//singleton method for low quantity proxy
	public static LowQuantityProxy getInstance()
	{
		if(instance == null)
		{
			instance = new LowQuantityProxy();
		}
			
		return instance;
	}
	
	public LowQuantityProxy()
	{
		if(next == null)
		{
			next = HighQuantityProxy.getInstance();
		}
	}
		
	@Override
	//checks the order size and forwards to the facade or the high quantity order proxy
	public void placeOrder(Map<String, Integer> orderDetails, Buyer buyer) {
		
		//forward request to next proxy in chain of responsibility if order size larger than 10
		if (orderDetails.size()>10)
		{
			next.placeOrder(orderDetails, buyer);
		}
		else
		{
			//forward request to facade
			Facade facade = Facade.getInstance();
			facade.placeOrder(orderDetails, buyer);
		}
		
	}

	@Override
	public void restock(Map<String, Integer> restockDetails, Supplier supplier) {
		// TODO Auto-generated method stub
		
	}

}
