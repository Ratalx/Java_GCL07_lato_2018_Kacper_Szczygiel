import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer1 {
    public static void main(String args[]) throws IOException {
        TestServer1 S1=new TestServer1();
        S1.run(444);
    }


    public void run(int port) throws IOException{
        ServerSocket svrSocket = new ServerSocket(port);
       Socket sock= svrSocket.accept();
        InputStreamReader inputStreamReader= new InputStreamReader(sock.getInputStream());
        BufferedReader buffReader= new BufferedReader(inputStreamReader);
        String Message = buffReader.readLine();
        System.out.println(Message);

        if(Message!=null){
            PrintStream printStream= new PrintStream(sock.getOutputStream());
            printStream.println("Message recived");
        }
    }
    public void stop(){

    }
    private void doClientLogic(Socket socket)throws IOException{

    }
}
