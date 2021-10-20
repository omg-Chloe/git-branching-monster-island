/*
 * Implementation of a simple client in java
 * By Srihari Nelakuditi for CSCE 416
 * Modified to fit two way communication by COS 2021.09.13
 */

// Package for I/O related stuff
import java.io.*;

// Package for socket related stuff
import java.net.*;

/*
 * This class does all the client's job
 * It connects to the server at the given address
 * and alternately sends messages typed by the user
 * and displays messages received from the server
 */
public class TwoWayMsgClient {

	/*
	 * The client program starts from here
	 */
	public static void main(String args[])
	{
		// Client needs server's contact information and user name
		if (args.length != 2) {
			System.out.println("usage: java OneWayMesgClient <host> <port>");
			System.exit(1);
		}

		// Be prepared to catch socket related exceptions
		try {
			// Connect to the server at the given host and port
			Socket sock = new Socket(args[0], Integer.parseInt(args[1]));
			System.out.println(
					"Connected to server at " + args[0] + ":" + args[1]);
            System.out.println("After sending message please wait for response from Server\n"
                    + "To discconect type close\n");

			// Prepare to read from server
			BufferedReader fromServerReader = new BufferedReader(
					new InputStreamReader(sock.getInputStream()));

			// Prepare to write to server with auto flush on
			PrintWriter toServerWriter =
					new PrintWriter(sock.getOutputStream(), true);

			// Prepare to read from keyboard
			BufferedReader fromUserReader = new BufferedReader(
					new InputStreamReader(System.in));

			// Keep doing till we get EOF from server or user
			while (true) {
				// Read a line from the keyboard
				String line;// = fromUserReader.readLine();

                //read line from Server
                String serverLine;// = fromServerReader.readLine();

				// If we get null, it means user is done
				//if (line == null) {
					//System.out.println("Closing connection");
					//break;
			    //}

                // changing while(line != null) to != "disconnect" 
                // because if client skips msg and server double messages
                // the skipped msg is counted as null 

                //while (!(line.equals("disconnect"))) {
                while (!(line = fromUserReader.readLine()).equals("close")) {    
                    //read line from Server
                    //serverLine = fromServerReader.readLine();
                    // Print the line received from Server
				    //System.out.println("Server: " + serverLine);
                    // Send the line to the server
				    toServerWriter.println(line);
                    //read line from Server
                    serverLine = fromServerReader.readLine();
                    // Print the line received from Server
				    System.out.println("Server: " + serverLine);
                }
				// Send the line to the server
				//toServerWriter.println(line);

                // Print the line received from Server
				//System.out.println("Server: " + serverLine);
                // close the socket and exit
			    //toServerWriter.close();
                System.out.println("Closing connection");
                sock.close();
                break;
			}

			// close the socket and exit
			//toServerWriter.close();
			//sock.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
