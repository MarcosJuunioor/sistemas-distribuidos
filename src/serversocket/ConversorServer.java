package serversocket;
import java.io.*;
import java.net.*;
import java.util.*;
/** 
 * Código criado para Exemplificar uma comunicação entre um cliente Telnet e um Server Socket.
 * Para se comunicar com esse servidor:
 * Compilar e Executar o arquivo. Em seguida, o cliente deve usar o comando: 
 * telnet ipdoservidor 8189
 * 
 * */
public class ConversorServer {
	public final static float DOLAR = 5.72f;

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
					out.println("** Conversor de Modeas: Dólar para Real **");
					
					boolean sair = false;
					 do{
						out.println("Digite um valor em Dólar: ");
						float valor = in.nextFloat();
						valor = valor / DOLAR;
						out.println("Resultado: "+valor);
						out.println("Fazer outra operação? s = sim, n = não");
						String line = in.next();
						if(line.trim().equals("n")) {
							sair = true;
						}
					}while(!sair && in.hasNextLine());
					 
					incoming.close();
					
				} catch(IOException e){
					
				}
		} catch (IOException e) {
			// TODO: handle exception
		}
	}

}
