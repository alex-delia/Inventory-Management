package ca.uwo.proxies;

import java.util.Map;
import java.util.Scanner;

import ca.uwo.client.Buyer;
import ca.uwo.client.Supplier;

/**
 * @author kkontog, ktsiouni, mgrigori
 * This is one concrete implementation of {@link ca.uwo.proxies.Proxy} base class, it is the first proxy
 * the {@link ca.uwo.client.Client} will encounter. If the request of client is not issued by this class, 
 * it is forwarded to the {@link ca.uwo.proxies.SupplierProxy}, then {@link ca.uwo.proxies.LowQuantityProxy}, 
 * lastly {@link ca.uwo.proxies.HighQuantityProxy}. The link between those proxies implements Chain of Responsibility 
 * design pattern.
 */
public class WelcomeProxy extends Proxy {
	
	//this is the only instance of the WelcomeProxyto implement the singleton design
	private static WelcomeProxy instance;
	private static Proxy next;
		
	//singleton method for WelcomeProxy 
	public static WelcomeProxy getInstance()
	{
		if(instance == null)
		{
			instance = new WelcomeProxy();
		}
			
		return instance;
	}
	
	public WelcomeProxy()
	{
		if(next==null)
		{
			next = SupplierProxy.getInstance();
		}
	}
		

	/* (non-Javadoc)
	 * @see ca.uwo.frontend.interfaces.FacadeCommands#placeOrder(java.util.Map, ca.uwo.client.Buyer)
	 */
	@Override
	public void placeOrder(Map<String, Integer> orderDetails, Buyer buyer) {
		if(authenticateUser(buyer))
		{
			next.placeOrder(orderDetails, buyer);
		}
		else
		{
			System.out.println("Authentication Failed.");
		}
		
	}

	/* (non-Javadoc)
	 * @see ca.uwo.frontend.interfaces.FacadeCommands#restock(java.util.Map, ca.uwo.client.Supplier)
	 */
	@Override
	public void restock(Map<String, Integer> restockDetails, Supplier supplier) {
		next.restock(restockDetails, supplier);
		
	}
	
	//method for authenticating the user by askign for username and password
	private boolean authenticateUser(Buyer buyer)
	{
		Scanner s = new Scanner(System.in);
		String usern;
		String pword;
		
		System.out.println("Verification of Buyer:");
		System.out.println("Enter Username:");
		usern = s.nextLine();
		System.out.println("Enter Password:");
		pword = s.nextLine();
		return (usern.contentEquals(buyer.getUserName())&&pword.contentEquals(buyer.getPassword()));
		
	}

}
