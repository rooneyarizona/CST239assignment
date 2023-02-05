package app;

/**
 * A class two create a StoreFront and Server Thread, which implement Runnable
 * 
 * @author Alastair Sagar
 * 
 *
 */

public class ThreadApp {
	
	public static void main(String[] args) {
		StoreFront store = new StoreFront();
		ServerThread server = new ServerThread();
		
		Thread storeThread = new Thread(store);
		Thread serverThread = new Thread(server);
		
		storeThread.start();
		serverThread.start();
		
	}
}
