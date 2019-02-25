/**This program creates a client program that sends a name to a server program
  *this program will then receive a list of names that the server has collected
  */

import java.io.*;

public class NamedClient
{
    public static void main (String[] args)
    {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        OutputStream nameSend = new OutputStream();
        try
        {
            System.out.println("Welcome to the Echo client.\n" +
                    "What is the name of the server host?");
            String hostName = br.readLine();
            if (hostName.length() == 0) // if user did not enter a name
                hostName = "localhost";  //   use the default host name
            System.out.println("What is the port number of the server host?");
            String portNum = br.readLine();
            if (portNum.length() == 0)
                portNum = "7";          // default port number

            System.out.println("Whats the name you want to send? ");
            String name = br.readLine();
            System.out.println(name);

            /**
            EchoClientHelper1 helper = new EchoClientHelper1(hostName, portNum);
            boolean done = false;
            String message, echo;
            while (!done)
            {
                System.out.println("Enter a line to receive an echo back from the server, "
                        + "or a single peroid to quit.");
                message = br.readLine( );
                if ((message.trim()).equals (endMessage))
                {
                    done = true;
                    helper.done( );
                }
                else
                { echo = helper.getEcho( message);
                    System.out.println(echo);
                }
            } // end while */
        } // end try
        catch (Exception ex)
        {
            ex.printStackTrace( );
        } // end catch
    } //end main
} //end class