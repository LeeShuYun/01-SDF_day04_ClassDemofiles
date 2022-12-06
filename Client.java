import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main (String[] args){
        int PORT = 12345;
        //we need a ip add and port number to connect to server
        try{
            Socket cs = new Socket("localhost", PORT);

            //get the io streams
            OutputStream os = cs.getOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(os);
            DataOutputStream dos = new DataOutputStream(bos);

            //now we will see this message at the server side 
            dos.writeUTF("Hello from client");
            dos.flush();
            System.out.println("Message has been sent to server");

        }catch (UnknownHostException e){
            System.out.println("Unable to reach the HOST");
        }catch(IOException e){
            System.out.println("IO Error");
        }

    }

}
