import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

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
            // dos.writeUTF("Hello from client");
            // dos.flush();
            // System.out.println("Message has been sent to server");

            Scanner inputSc = new Scanner(System.in);
            String line;


            //as long as something's in terminal
            while ((line = inputSc.nextLine()) != null){

                //end loop clause. closes our connection to the server
                if (line.equalsIgnoreCase("close")){
                    System.out.println("Exit from shell");
                    break;
                }

                //prints out the line 
                dos.writeUTF(line);
                dos.flush();
                System.out.println("Message sent to server: " + line);
            }
            //clean up by closing socket and scanner
            cs.close();
            inputSc.close();

        }catch (UnknownHostException e){
            System.out.println("Unable to reach the HOST");
        }catch(IOException e){
            System.out.println("IO Error");
        }

    }

}
