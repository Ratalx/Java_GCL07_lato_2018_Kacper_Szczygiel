import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SomeClient implements Runnable {
    Socket SOCK;
    Scanner INPUT;
    Scanner SEND= new Scanner(System.in);
    PrintWriter OUT;

    public SomeClient(Socket X){
        this.SOCK=X;
    }
    public void run(){
        try{
            try{
                INPUT= new Scanner(SOCK.getInputStream());
                OUT= new PrintWriter(SOCK.getOutputStream());
                OUT.flush();
                CheckStream();

            }
            finally {
                SOCK.close();
            }
        }catch(Exception X){System.out.print(X);}
    }
    public void DISCONNECT() throws IOException {

        OUT.println(chatClient.UserName+ " has disconnected");;
        OUT.flush();
        SOCK.close();
        JOptionPane.showMessageDialog(null, "You disconnected");
        System.exit(0);
    }

    public void CheckStream(){
        while(true){
            RECEIVE();
        }
    }

    public void RECEIVE(){
        if(INPUT.hasNext()){
            String MESSAGE= INPUT.nextLine();

            if(MESSAGE.contains("#?!")){
                String TEMP1= MESSAGE.substring(3);
                TEMP1=TEMP1.replace("[","");
                TEMP1=TEMP1.replace("]","");

                String [] CurrentUsers = TEMP1.split(", ");
                chatClient.JL_ONLINE.setListData(CurrentUsers);
            }
            else{
                chatClient.TA_CONVERSATION.append(MESSAGE+"\n");
            }
        }
    }

    public void SEND(String X){
        OUT.println(chatClient.UserName+": "+X);
        OUT.flush();
        chatClient.TF_Message.setText("");
    }


}
