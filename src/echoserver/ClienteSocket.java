package echoserver;
import java.io.*;
import java.net.*;

public class ClienteSocket {
	public static void main(String args[]) {
		try {
			Socket s = new Socket("time-A.timefreq.bldrdoc.gov",13); 
			/* Socket: classe usada no lado do cliente que permite comunicação 
			 * com uma aplicação do servidor criando um "tubo full duplex", 
			 * por onde tanto o cliente pode receber/enviar dados, quanto 
			 * o servidor. O socket, no lado do cliente, recebe o endereço do 
			 * servidor e a porta usada pela aplicação. Um servidor tem no máximo 
			 * 2^16 portas.
			 * OBS: o socket permite uma comunicação via tcp/ip.  */
			
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			boolean more = true;
			
			while(more) {
				String line = in.readLine();
				if(line == null) more = false;
				else System.out.println(line);
			}
		}catch(IOException e) {
			System.out.println("Error: "+e);
			
		}
	}

}
