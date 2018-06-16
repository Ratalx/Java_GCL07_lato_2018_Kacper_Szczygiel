import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class chatServer
{
    public static ArrayList<Socket> ConnectionArray=new ArrayList<Socket>();
    public static ArrayList<String> CurrentUsers = new ArrayList<String>();

    public static void main(String argv[])
    {
        try{
            final int PORT=1444;
            ServerSocket Server = new ServerSocket(PORT);
            System.out.println("Waiting for clients");

            while(true)
            {
                Socket socket= Server.accept();
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

    public static void AddUserName(Socket X)throws IOException{

        Scanner INPUT = new Scanner(X.getInputStream());
        String UserName = INPUT.nextLine();
        CurrentUsers.add(UserName);

        for(int i=1;i<=chatServer.ConnectionArray.size();i++){
            Socket tempSock=chatServer.ConnectionArray.get(i-1);
            PrintWriter OUT = new PrintWriter(tempSock.getOutputStream());
            OUT.println("#?"+CurrentUsers);
            OUT.flush();
        }
    }
}
