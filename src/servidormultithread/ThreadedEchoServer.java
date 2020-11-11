/** O código abaixo é um exemplo de servidor java que pode se comunicar com diversos clientes
 * criando uma thread para cada nova conexão. Também foi implementada uma rotina por meio da 
 * qual o servidor consegue enviar uma mensagem para todos os clientes conectados.
 * */

package servidormultithread;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class ThreadedEchoServer
{ static int i = 1;
  public static void main(String[] args )
   {
      try
      { 
    	 ServerSocket s = new ServerSocket(8189);
	  	 ArrayList<Socket> sockets = new ArrayList<Socket>();
         for (;;)
         {
        	sockets.add(s.accept());
        	
            System.out.println("Spawning " + i);
            new ThreadedEchoHandler(sockets.get(i-1), i).start();
            
            for(int j=0; j<sockets.size(); j++) {
	            BufferedReader in = new BufferedReader
	                    (new InputStreamReader(sockets.get(j).getInputStream()));
	         	PrintWriter out = new PrintWriter
	                    (sockets.get(j).getOutputStream(), true /* autoFlush */);
	         	out.println("Cliente "+i+" conectado.");
            }
            i++;
         }
      }
      catch (Exception e)
      {  System.out.println(e);
      }
   }
}

class ThreadedEchoHandler extends Thread
{  public ThreadedEchoHandler(Socket sock, int c)
   { incoming = sock; counter = c; }

   public void run()
   {  try
      {  BufferedReader in = new BufferedReader
            (new InputStreamReader(incoming.getInputStream()));
         PrintWriter out = new PrintWriter
            (incoming.getOutputStream(), true /* autoFlush */);

         out.println( "Hello! Enter BYE to exit." );

         boolean done = false;
         while (!done)
         {  String str = in.readLine();
             System.out.println (ThreadedEchoServer.i + " - " +str);
            if (str == null) done = true;
            else
            {
              out.println("Echo (" + counter + "): " + str);
               if (str.trim().equals("BYE"))
                  done = true;
            }
         }
         incoming.close();
      }
      catch (Exception e)
      {  System.out.println(e);
      }
   }

   private Socket incoming;
   private int counter;
}
