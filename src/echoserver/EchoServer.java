package echoserver;
import java.io.*;
import java.net.*;
import java.util.*;

public class EchoServer {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket s = new ServerSocket(8189);
			Socket incoming = s.accept();
				try {
					InputStream inStream = incoming.getInputStream();
					OutputStream outStream = incoming.getOutputStream();
					Scanner in = new Scanner(inStream);
					PrintWriter out = new PrintWriter(outStream, true /** autoflush*/);
					out.println("Olá, digite 'bye' para sair.");
					boolean done = false;
					while(!done && in.hasNextLine()) {
						String line = in.nextLine();
						out.println("Echo: "+line);
						if(line.trim().equals("bye")) {
							done = true;
						}
					}
					 
					incoming.close();
					
				} catch(IOException e){
					
				}
		} catch (IOException e) {
			// TODO: handle exception
		}
	}

}
