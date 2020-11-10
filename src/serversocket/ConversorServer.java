package serversocket;
import java.io.*;
import java.net.*;
import java.util.*;
/** 
 * C�digo criado para Exemplificar uma comunica��o entre um cliente Telnet e um Server Socket.
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
					out.println("** Conversor de Modeas: D�lar para Real **");
					
					boolean sair = false;
					 do{
						out.println("Digite um valor em D�lar: ");
						float valor = in.nextFloat();
						valor = valor / DOLAR;
						out.println("Resultado: "+valor);
						out.println("Fazer outra opera��o? s = sim, n = n�o");
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
