package app;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;
/**
 * Admin Console to connect with ServerThread class to add JSON inventory items
 * 
 * 
 * @author Alastair Sagar
 * 
 *
 */
public class AdminService extends Thread {
	private SocketChannel socket;
	private final int port = 6666;

	public AdminService() throws IOException {
		this.socket = SocketChannel.open();
	}

	public static void main(String[] args) throws IOException {
		try {
			AdminService admin = new AdminService();
			admin.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		try {
			// Connects to localhost and port to connect with ServerThread
			socket.connect(new InetSocketAddress("localhost", port));
			System.out.println("Connected to Server");
			System.out.println();
			System.out.println("Administration Console Application:");
			boolean adminMenu = true;
			
			// Admin Menu to loop until 'Q' command
			while (adminMenu) {
				Scanner scan = new Scanner(System.in);
				System.out.println("What is your command? Please separate command and payload with '|'");
				System.out.println("U| UpdateInventory (include payload in JSON format)\nR| Return Inventory\nQ| Quit");

				//Input command
				String message = scan.nextLine();

				// Create ByteBuffer to send message to ServerThread
				ByteBuffer buffer = ByteBuffer.allocate(1040);
				buffer.put(message.getBytes());
				buffer.flip();
				socket.write(buffer);

				//Receive Server Response
				ByteBuffer responseBuffer = ByteBuffer.allocate(1024);
				socket.read(responseBuffer);
				responseBuffer.flip();
				String response = new String(responseBuffer.array()).trim();
				System.out.println(response);
				System.out.println();

				//Close Admin Menu with Q command
				if (message.equals("Q|")) {
					scan.close();
					System.out.println("Admin Console Closed");
					adminMenu = false;
					cleanUp();
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//Close socket and connection to sever
	public void cleanUp() throws IOException {
		socket.close();
	}

}
