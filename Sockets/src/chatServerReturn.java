import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class chatServerReturn implements Runnable{
    Socket socket;
    private Scanner inputScan;
    private PrintWriter pWriter;
    String message="";
    public chatServerReturn(Socket X){
        this.socket=X;
    }
    public void CheckConnection() throws IOException {
        if(!socket.isConnected()){
            for(int i =0;i<chatServer.ConnectionArray.size();i++)
            {
                if(chatServer.ConnectionArray.get(i)==socket){
                    chatServer.ConnectionArray.remove(i);
                }
            }
            for(int i =1;i<chatServer.ConnectionArray.size();i++){
                Socket tempSock=(Socket) chatServer.ConnectionArray.get(i-1);
                PrintWriter tempOut= new PrintWriter(tempSock.getOutputStream());
                tempOut.println(tempSock.getLocalAddress().getHostName()+"disconnected!");
                tempOut.flush();
                System.out.println(tempSock.getLocalAddress().getHostName()+"disconnected!");
            }
        }
    }
    public void run() {
        try {
            try {
                inputScan=new Scanner(socket.getInputStream());
                pWriter=new PrintWriter(socket.getOutputStream());

                while (true)
                {
                    CheckConnection();

                    if(!inputScan.hasNext()){
                        return;
                    }
                    message = inputScan.nextLine();
                    System.out.println("Client said:"+ message);

                    for(int i =1;i<=chatServer.ConnectionArray.size();i++)
                    {
                        Socket tempSock= chatServer.ConnectionArray.get(i-1);
                        PrintWriter tempOut= new PrintWriter(tempSock.getOutputStream());
                        tempOut.println(message);
                        tempOut.flush();
                        System.out.println("Sent to: "+tempSock.getLocalAddress().getHostName());
                    }

                }
            }
            finally {
                socket.close();
            }
        }catch (Exception x){
            System.out.println(x+"cos");
        }


    }
}
