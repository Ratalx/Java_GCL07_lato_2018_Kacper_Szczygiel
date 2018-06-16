import java.io.*;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomServer {
    public static ArrayList<Socket> ConnectionArray=new ArrayList<Socket>();
    public static ArrayList<String> CurrentUsers = new ArrayList<String>();
    public static int  numberOfUsers =0;

    public static void main(String argv[])
    {
        try{
            final int PORT=1444;
            ServerSocket Server = new ServerSocket(PORT);
            System.out.println("Waiting for clients");

            while(true)
            {

                Socket socket= Server.accept();
                if(numberOfUsers<5)
                ConnectionArray.add(socket);

                System.out.println("Client connected from: "+socket.getLocalAddress().getHostName());

                AddUserName(socket);

                chatServerReturn chat = new chatServerReturn(socket);
                Thread x = new Thread(chat);
                x.start();
            }
        }
        catch (Exception e)
        {
            System.out.println(e+"cos1");
        }
    }
    public static void AddUserName(Socket X)throws IOException {

        Scanner INPUT = new Scanner(X.getInputStream());
        String UserName = INPUT.nextLine();
        CurrentUsers.add(UserName);

        for (int i = 1; i <= chatServer.ConnectionArray.size(); i++) {
            Socket tempSock = chatServer.ConnectionArray.get(i - 1);
            PrintWriter OUT = new PrintWriter(tempSock.getOutputStream());
            OUT.println("#?" + CurrentUsers);
            OUT.flush();
        }
    }
    public void run(int port) throws IOException{
        ServerSocket svrSocket = new ServerSocket(port);
        Socket sock= svrSocket.accept();
        ConnectionArray.add(0,sock);
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
