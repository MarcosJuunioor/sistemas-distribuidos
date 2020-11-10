package clienteservidorjava;
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Cliente{ 
	
	public static void main(String[] arg){ 
	    Socket s = null;
	    
	    try{ 
	    	System.out.println("Conectando...");
	    	s = new Socket("10.0.0.107",6789);
	    	DataInputStream in = new DataInputStream(s.getInputStream());
	    	DataOutputStream out = new DataOutputStream(s.getOutputStream());
	    	System.out.println("Conectado. Digite o numero desejado e tecle enter.");
	    	
	    	boolean enviar = true;
	    	int contador = 1;
	    	while(enviar) {
	    		System.out.println("Digite o "+contador+" numero");
	    		contador++;
	    		
	    		Scanner ler = new Scanner(System.in);
	    		double numero = ler.nextDouble();
    			out.writeDouble(numero);
    			
    			System.out.println("Deseja enviar outro numero? Digite 1 para sim ou 0 para nao.");
    			int resposta = ler.nextInt();
    			if(resposta == 0) {
    				enviar = false;
    			}
	    	}
	    	out.flush();
	    	out.writeDouble(-1.0);
	    	System.out.println("Somatorio = "+in.readDouble());
      	}catch(Exception e){ 
      		System.out.println("Erro: "+e.getMessage()); 
  		}
      	finally{ 
      		try{
      			if(s!=null) s.close();
  			}catch(Exception e2){}    
  		}
	    System.out.println("Conexao encerrada");
	    try{
	    	System.in.read();
    	}catch(Exception e3){}
	}
}


