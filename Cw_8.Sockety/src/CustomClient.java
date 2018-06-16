import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class CustomClient {
  //  private DataInputStream localInput;
   // private Scanner scanner;
    private String userName="none",password="none";
    private Socket socket;
    public static void main(String args[]){
        CustomClient customClient=new CustomClient();
        try {
           // customClient.localInput=new DataInputStream(System.in);
            Scanner scanner = new Scanner(System.in);

            DataInputStream localInput=new DataInputStream(System.in);
            customClient.connect("localhost",1444);
            DataInputStream input = new DataInputStream(customClient.socket.getInputStream());
            DataOutputStream output = new DataOutputStream(customClient.socket.getOutputStream());
            while (true){
            System.out.println("1.Login\n2.ping\n3.echo\n4.Logout\n5.Disconnect");
            int a= scanner.nextInt();
            output.writeInt(a);
            output.flush();
            System.out.println(a);
                  switch(a) {
                      case 1:
                          System.out.println("userName:");
                          customClient.userName = scanner.next();
                          System.out.println("passowrd:");
                          customClient.password = scanner.next();
                          if(customClient.login(customClient.userName, customClient.password))
                              System.out.println("You are logged in");
                          break;
                      case 2:
                          System.out.println("ping ... result :" + customClient.ping());
                          break;
                      case 3:
                          System.out.println("echo ... result :"+customClient.echo("Hello World"));
                          break;
                      case 4:
                          customClient.logout();
                          break;
                      case 5:
                          customClient.disconnect();
                          break;
                      default:
                          System.out.println(a);

                  }
            }
        } catch (IOException e) {
            System.out.println("Connection failure");
        }

    }
    public void connect(String host,int port) throws IOException{
        socket= new Socket(host,port);
        DataInputStream inputStream=new DataInputStream(socket.getInputStream());
        System.out.println(inputStream.readUTF());
    }
    public void disconnect(){
        System.out.println("disconneting...");
        try {
            socket.close();
        } catch (IOException e) {
            System.out.println(e);
        }

    }
    public boolean login(String username,String passowrd)throws IOException{
        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());
       // PrintWriter output = new PrintWriter(socket.getOutputStream());
        //output.writeInt(1);
        //System.out.println(input.readUTF());
        output.writeUTF(username);
       // System.out.println(input.readUTF());
        output.writeUTF(passowrd);
       // output.flush();
      int i = input.readInt();
      if(i==1)
          return true;
      else
          return false;
    }
    public void logout()throws IOException{
        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());
      //  output.writeInt(4);
        //output.flush();
        System.out.println(input.readUTF());


    }
    public boolean ping()throws IOException{
        DataInputStream input = new DataInputStream(socket.getInputStream());
        //output.flush();
        System.out.println(input.readUTF());
        int i = input.readInt();
        if(i==1) {
            return true;
        }
        else{
            return false;
        }
    }
    public boolean echo(String text) throws IOException{
        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
        System.out.println(inputStream.readUTF());
        outputStream.writeUTF(text);
        String text2 = inputStream.readUTF();
        if(text.equals(text2)) {
            return true;
        }
        else{
            return false;
        }
    }
}
