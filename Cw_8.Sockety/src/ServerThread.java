import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Scanner;

public class ServerThread implements Runnable {

    private String password="none",userName="none";
    private Socket socket;
    Scanner scanner;
    private DataOutputStream output;
    private DataInputStream input;
    private boolean isInterupted = false;
    private boolean isLogged=false;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }
    public boolean valid(String userName,String password){


        return true;
    }


    @Override
    public void run() {

        try {
            try {
                output = new DataOutputStream(socket.getOutputStream());
                input = new DataInputStream(socket.getInputStream());
               // scanner = new Scanner(socket.getInputStream());

                while (!isInterupted) {
                    if(output!=null&&input!=null&&scanner!=null)
                    System.out.println("threadStart");
                    int i=input.readInt();

                    switch (i) {

                        case 1:
                            userName=input.readUTF();
                            password=input.readUTF();
                            if(valid(userName,password)){
                                output.writeInt(1);
                            //output.flush();
                            isLogged=true;
                            }
                            else {
                                output.write(0);
                             //   output.flush();
                            }
                            break;
                        case 2:
                            if(isLogged) {
                                output.writeUTF("Pingging ...");
                                    output.writeInt(1);
                            }
                            else {
                                output.writeUTF("You are not allowed to ping login...");
                                output.writeInt(0);
                           //     output.flush();
                            }
                            break;
                        case 3:
                            if(isLogged){
                                output.writeUTF("Echo....");
                            String message=input.readUTF();
                            System.out.println(message);
                            output.writeUTF(message);
                         //   output.flush();
                            }
                            else {
                                output.writeUTF("You can't echo becouse you are not logged in");
                                String message=input.readUTF();
                                output.writeUTF("null");
                       //         output.flush();
                            }
                            break;
                        case 4:
                            output.writeUTF("Logout ...");
                     //       output.flush();
                            isLogged=false;
                            break;
                        case 5:
                            Thread.currentThread().interrupt();
                            break;
                            default:
                                System.out.println(i);
                    }
                   // output.flush();
                }

            } finally {
                socket.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
