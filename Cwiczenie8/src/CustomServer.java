import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomServer {
    public ArrayList<Socket>ConnectionArray=new ArrayList<Socket>(5);
    public ArrayList<String>CurrentUsers=new ArrayList<String>(5);
    private int numberOfUsers=0;


    public static void main(String args[]) {
        final int  port =1444;
        CustomServer server=new CustomServer();
        try {

            server.run(port);
        }catch (Exception e){
            System.out.println(e);
        }
    }


    public void run(int port) throws IOException{
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Waiting for clients");
        while(true){
            Socket sock = serverSocket.accept();

          DataOutputStream outputStream = new DataOutputStream(sock.getOutputStream());
        if(numberOfUsers<5)
        {
            outputStream.writeUTF("You are connected :D");
            ConnectionArray.add(sock);
           // AddUserName(sock);
            numberOfUsers++;
            ServerThread st=new ServerThread(sock);
            Thread thread = new Thread(st);
            thread.start();
        }
        else {
            outputStream.writeUTF("Reached the limit of connections");
            sock.close();
        }
        }
    }

    private boolean valid(Socket sock) throws IOException{


        return true;
    }
    private void  AddUserName(Socket sock) throws IOException
    {
        Scanner input = new Scanner(sock.getInputStream());
        String UserName = input.nextLine();
        CurrentUsers.add(UserName);
        PrintWriter pw= new PrintWriter(sock.getOutputStream());
        pw.println("you are connected as "+UserName);
    }
}
