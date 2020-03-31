import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMutlithread extends  Thread{

	private int nbclientsConnected;
	
	@Override
	public void run() {
		try {
			ServerSocket ss= new ServerSocket(456);
			while(true) { 
				Socket s=ss.accept();
				++nbclientsConnected ; 
				new ServiceClient(s,nbclientsConnected).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new  ServerMutlithread().start();
		
		
	} 

}
