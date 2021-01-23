package ca.uwo.proxies;

import java.util.Map;

import ca.uwo.client.Buyer;
import ca.uwo.client.Supplier;
import ca.uwo.frontend.Facade;

public class SupplierProxy extends Proxy{
	
	//this is the only instance of the supplier proxy to implement the singleton design
	private static SupplierProxy instance;
	
	//next Proxy in the chain of responsibility
	private static Proxy next;
		
	//singleton method for supplier proxy
	public static SupplierProxy getInstance()
	{
		if(instance == null)
		{
			instance = new SupplierProxy();
		}
			
		return instance;
	}
	
	public SupplierProxy()
	{
		if(next==null)
		{
			next = LowQuantityProxy.getInstance();
		}
	}

	@Override
	public void placeOrder(Map<String, Integer> orderDetails, Buyer buyer) {
		next.placeOrder(orderDetails, buyer);
	}

	@Override
	public void restock(Map<String, Integer> restockDetails, Supplier supplier) {
		//redirects restock operation to the facade
		Facade facade = Facade.getInstance();
		facade.restock(restockDetails, supplier);
		
	}

}
