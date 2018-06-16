import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class TestClient {

    public static void main(String args[]) throws IOException{
        TestClient C1=new TestClient();
        C1.connect("localhost",444);
    }

    public void connect(String host, int port) throws IOException{

        Socket sock= new Socket(host,port);
        PrintStream printStream=new PrintStream(sock.getOutputStream());
        printStream.println("Hello to server from Client");

        InputStreamReader inputStreamReader = new InputStreamReader(sock.getInputStream());
        BufferedReader buffReader= new BufferedReader(inputStreamReader);
        String message = buffReader.readLine();
        System.out.println(message);

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
