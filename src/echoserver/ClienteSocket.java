package echoserver;
import java.io.*;
import java.net.*;

public class ClienteSocket {
	public static void main(String args[]) {
		try {
			Socket s = new Socket("time-A.timefreq.bldrdoc.gov",13); 
			/* Socket: classe usada no lado do cliente que permite comunica��o 
			 * com uma aplica��o do servidor criando um "tubo full duplex", 
			 * por onde tanto o cliente pode receber/enviar dados, quanto 
			 * o servidor. O socket, no lado do cliente, recebe o endere�o do 
			 * servidor e a porta usada pela aplica��o. Um servidor tem no m�ximo 
			 * 2^16 portas.
			 * OBS: o socket permite uma comunica��o via tcp/ip.  */
			
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
