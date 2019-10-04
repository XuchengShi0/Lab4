import java.net.*;
import java.util.Scanner;
import java.util.Random;

public class UDPSender {

	public static void main(String[] args) 
   {
	      // Check the arguments
	      if( args.length != 2 )
	      {
	         System.out.println( "usage: java UDPSender host port" ) ;
	         return ;
	      }
	      DatagramSocket socket = null ;
	      try
	      {
	         // Convert the arguments first, to ensure that they are valid
	         InetAddress host = InetAddress.getByName( args[0] ) ;
	         int port         = Integer.parseInt( args[1] ) ;
	         socket = new DatagramSocket() ;
	         Random rng = new Random();
     
	         Scanner in;
	         in = new Scanner (System.in);
	         String message = null;
	         int i = 0;
	         while (i<10)
	         {
	        		 System.out.println("Enter text to be sent, ENTER to quit ");
	        		 message = ""+rng.nextInt();
	        		 if (message.length()==0) break;
	        		 byte [] data = message.getBytes() ;
	        		 DatagramPacket packet = new DatagramPacket( data, data.length, host, port ) ;
	        		 socket.send( packet ) ;
	        		 i++;
	         } 
	         System.out.println ("Closing down");
	      }
	      catch( Exception e )
	      {
	         System.out.println( e ) ;
	      }
	      finally
	      {
	         if( socket != null )
	            socket.close() ;
      }
   }
}

