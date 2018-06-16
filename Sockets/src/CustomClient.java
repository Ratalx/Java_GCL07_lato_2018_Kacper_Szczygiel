import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class CustomClient {
    private SomeClient ChatClient;
    private  String UserName="None";
    private  String password="None";
    public static void main(String args[]) throws IOException{
       int choice =0;
       CustomClient client1=new CustomClient();
       Scanner scanner= new Scanner(System.in);
       while (choice==0)
       {
           System.out.println("1.Connect\n2.Disconnect\n3.Echo\n4.Ping");

        choice=scanner.nextInt();
        switch (choice){
            case 1:
                client1.connect("localhost",1444);
                break;
//            case 2:
//                client1.disconnect();
//                break;
//            case 3:
//                client1.echo("cos");
//                break;
//            case 4:
//                client1.ping();
//                break;
            default:
                return;
        }
       }
    }

    public  void connect(String host, int port) throws IOException{
        try{
            Scanner scanner = new Scanner(System.in);
            Socket sock = new Socket(host, port);
            System.out.println("Login:");
            UserName=scanner.next();
            System.out.println("Passowrd:");
            password=scanner.next();

            System.out.println("You connected to: "+host);

            ChatClient = new SomeClient(sock);

            PrintWriter OUT = new PrintWriter(sock.getOutputStream());
            OUT.println(UserName);
            OUT.println(password);
            OUT.flush();

            Thread X = new Thread(ChatClient);
            X.start();
        }catch(Exception X){
            System.out.print(X);
            JOptionPane.showMessageDialog(null, "Server not responding.");
            System.exit(0);
        }
    }
    public void disconnect(){

    }
    public boolean login(String username,String password)throws IOException{

        return false;
    }
    public void logout()throws IOException{

    }
    public boolean ping() throws IOException {
        return false;
    }
    public boolean echo(String text) throws IOException{
        return false;
    }
}
