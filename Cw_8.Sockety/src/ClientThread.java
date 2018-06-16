import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ClientThread implements Runnable {
    private Socket socket;
    DataOutputStream output;
    DataInputStream input;
    DataInputStream localInput;

   public ClientThread(Socket sock){
        socket=sock;
    }

    @Override
    public void run() {

       try {
           try {
               output=new DataOutputStream(socket.getOutputStream());
               input = new DataInputStream(socket.getInputStream());
               localInput=new DataInputStream(System.in);
               System.out.println("1.Login\n2.ping\n3.echo\n4.Logout\n5.Disconnect");
                while (!Thread.interrupted()){



                }
           }finally {
               socket.close();
           }
       }catch (Exception e){
           System.out.println(e);
       }



    }
}
