import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server
 */
public class Server {

    public static void main(String[] args){
        System.out.println("Socket Server :");
        int PORT = 12345;

        //create server socket. Remember that the server has to be running first before client
        try{
            ServerSocket server = new ServerSocket(PORT);

            //opens the server socket to listen for and accept connections
            Socket socket = server.accept();

            //new connection from a client should be coming in here

            //we pick up the client's message with the input streams
            InputStream is = socket.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            DataInputStream dis = new DataInputStream(bis);

            //reads the data from the stream, if available. or closes 
            //in this case we should see "Hello from client"
            String msg = dis.readUTF();

            //once we get the message we confirm it with our own print
            System.out.println("MSG received ->" + msg);

            //server closes the socket after getting the message
            socket.close();

        }
        catch (IOException e){
            System.out.println("IO Error");

        }
    }
}