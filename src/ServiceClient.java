import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ServiceClient extends Thread {

	private int numeroClient;
	private Socket s;

	@Override
	public void run() {

		InputStream is;
		try {
			is = s.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			OutputStream os = s.getOutputStream();
		    PrintWriter	pw = new PrintWriter(os,true);
		    System.out.println("connextion du client numero :" + numeroClient);
		    pw.println("vous etre le client numero: " + numeroClient);
		    while(true) {
		    	String req=br.readLine();
		    	pw.println(req.length());
		    	
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ServiceClient(Socket s, int numeroClient) {
		super();
		this.numeroClient = numeroClient;
		this.s = s;
	}

	public ServiceClient() {
		super();
		// TODO Auto-generated constructor stub
	}

}
