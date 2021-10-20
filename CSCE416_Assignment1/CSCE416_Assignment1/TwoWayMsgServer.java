/*
 * Implementation of a simple server in java
 * By Srihari Nelakuditi for CSCE 416
 * Modified to fit two way communication by COS 2021.09.13
 */

 /*
  * Lessons learned: 
  * if reading from client is done in first loop it will keep printing fisrt message
  * if statment was checking line before second while loop
  * I needed while loop to read from the client for every message so I moved the check
  * to the bottom outside of the second while loop if null happens the print client closed connection happens
  * 
  * I can't send double messages EX: client: hi client: sup have to wait for Server response
  *
  */

// Package for I/O related stuff
import java.io.*;

// Package for socket related stuff
import java.net.*;

/*
 * This class does all the server's job
 */
public class TwoWayMsgServer {
	/*
	 * The server program starts from here
	 */	
	public static void main(String args[]) {
		// Server needs a port to listen on
		if (args.length != 1) {
			System.out.println("usage: java OneWayMesgServer <port>");
			System.exit(1);
		}
		
		// Be prepared to catch socket related exceptions
		try {
			// Create a server socket with the given port
			ServerSocket serverSock = 
					new ServerSocket(Integer.parseInt(args[0]));
			System.out.println("Waiting for a client ...");
			
			// Wait for a client
			Socket clientSock = serverSock.accept();
			System.out.println("Connected to a client");
			
			// Got a client, server socket not needed anymore
			serverSock.close();
			
			// Prepare to read from client
			BufferedReader fromClientReader = new BufferedReader(
					new InputStreamReader(clientSock.getInputStream()));
			
			// Prepare to write to client with auto flush on
			PrintWriter toClientWriter =
					new PrintWriter(clientSock.getOutputStream(), true);

			// Prepare to read from keyboard
			BufferedReader fromUserReader = new BufferedReader(
					new InputStreamReader(System.in));

			// Keep doing till client sends end-of-file (EOF)
			while (true) {
				// Read a line from the client
				String line;// = fromClientReader.readLine();

                //read line from keyboard
                //String output = fromUserReader.readLine();

				// If we get null, it means client sent EOF
				/*if (line == null) {
					System.out.println("Client closed connection");
					break;
				}*/
                // Print the line received from client
				    //System.out.println("Client: " + line);
                // while client is not EOF
                while ((line = fromClientReader.readLine())!= null) {
                    // Print the line received from client
				    System.out.println("Client: " + line);
                    //read line from keyboard
                    String output = fromUserReader.readLine();
                    // Send the line to the Client
				    toClientWriter.println(output);
                }
                System.out.println("Client closed connection");
                clientSock.close();
				break;

				// Print the line received from client
				//System.out.println("Client: " + line);

                // Send the line to the Client
				// toClientWriter.println(output);
                // close the client socket and exit
			    //clientSock.close();
			}
			
			// close the client socket and exit
			// clientSock.close();
		}
		catch(Exception e) {
			// print the exception message
			System.out.println(e);
		}
	}
}
