/**This program creates a server that accepts names from client programs
  *The server then accumulates the names and sends them back to the current client
 */

import java.io.*;
import java.util.*;

public class CollectingServer
{
    public static void main (String[] args)
    {
        // default port
        int serverPort = 7;
        if (args.length == 1)
            serverPort = Integer.parseInt(args[0]);
        try
        {
            // instantiates a datagram socket for both sending
            // and receiving data
            MyServerDatagramSocket mySocket = new MyServerDatagramSocket(serverPort);
            System.out.println("Collecting Server is ready.");

            Vector<String> nameList = new Vector<String>();

            //infinite loop


            while (true)
            {
                DatagramMessage request = mySocket.receiveMessageAndSender();
                System.out.println("Name received.");

                String name = request.getMessage();
                nameList.add(name);



                mySocket.sendMessage(request.getAddress(),request.getPort(), name);
            } //end while
        } //end try
        catch (Exception ex)
        {
            ex.printStackTrace();
        } //end catch

    } //end main
} //end class