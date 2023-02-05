package app;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * SeverThread class to communicate with AdminService and StoreFront to update inventory
 * 
 * 
 * @author Alastair Sagar 
 *
 */

public class ServerThread implements Runnable {

	private static final int port = 6666;
	private ServerSocketChannel serverSocket;
	private SocketChannel socket;
	private InventoryManager im = new InventoryManager();
	private List<SalableProduct> products = im.getInventoryList();

	public ServerThread() {
		this.products = im.getInventoryList();
	}
	
	public void run() {
			
		try {
			// Open severSocket Channel to accept client write
			serverSocket = ServerSocketChannel.open();
			serverSocket.bind(new InetSocketAddress(port));
			socket = serverSocket.accept();

			// Create new ByteBuffer to hold data
			ByteBuffer buffer = ByteBuffer.allocate(1024);

			// Loop to continue to receive client messages
			while (true) {
				buffer.clear();
				socket.read(buffer);
				buffer.flip();

				// Split string to take payload after command as product info
				String input = new String(buffer.array()).trim();
				String[] command = input.split("\\|");
				String jsonProduct = "";

				// Update inventory with product in JSON format
				if (command[0].equals("U")) {
					jsonProduct = input.substring(command[0].length() + 1);
					im.addProduct(jsonProduct);
					serverMessage("Your Product was Added");
				}
				// Return inventory to AdminSevice
				else if (command[0].equals("R")) {
					List<SalableProduct> products = im.getInventoryList();
					String returnInventory = inventoryString(products);
					serverMessage("Inventory:\n" + returnInventory);
				}
				// Quit connection to client/AdminService
				else if (command[0].equals("Q")) {
					serverMessage("Disconnected From Sever");
					cleanUp();
				} else {
					serverMessage("Incorrect entry. Please use U, R or Q commands!");
				}
			}
		} catch (ClosedChannelException e) {
			System.out.println("");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Method to send message in ByteBuffer back to AdminService Console
	public void serverMessage(String response) throws IOException {
		ByteBuffer buffer = ByteBuffer.wrap(response.getBytes(StandardCharsets.UTF_8));
		socket.write(buffer);

	}

	private String inventoryString(List<SalableProduct> products) {
		StringBuilder builder = new StringBuilder();
		for (SalableProduct product : products) {
			builder.append(product.toString());
			builder.append(System.lineSeparator());
		}
		return builder.toString();
	}

	public void cleanUp() throws IOException {
		serverSocket.close();
		socket.close();
	}
}