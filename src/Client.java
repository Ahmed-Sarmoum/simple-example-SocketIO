import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket("localhost",1234);

            System.out.println("Addition 2 number : ");
            while (true) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
                BufferedReader serverInput = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                System.out.println("Enter First Number : ");
                String first =  reader.readLine() + " ";

                System.out.println("Enter Operation : ");
                String operation =  reader.readLine() + " ";

                System.out.println("Enter Second Number : ");
                String second =  reader.readLine() + " ";

                String str = first+operation+second;

                dataOutputStream.writeBytes(str  + "\n");
                String str3 = serverInput.readLine();

                System.out.println("Sum is : "+str3);
                break;
             }
            clientSocket.close();
        } catch (IOException e) {
            System.out.println("Client => "+e.getMessage());
            e.printStackTrace();
        }
    }
}
