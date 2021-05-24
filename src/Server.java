import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(1234);


        while (true) {
            Socket server = serverSocket.accept();
            System.out.println("Server starting ...");
            String str11 = "";
            String [] temp;
             BufferedReader reader = new BufferedReader(new InputStreamReader(server.getInputStream()));
            DataOutputStream outputStream = new DataOutputStream(server.getOutputStream());
            str11 = reader.readLine();
            temp = str11.split(" ");
            float sum = 0.0f;

            Float num1 = Float.parseFloat(temp[0]) ;
            Float num2 = Float.parseFloat(temp[2]) ;
            if (temp[1].equals( "+")) {sum = num1 + num2;}
            else if (temp[1].equals("-")) {sum = num1 - num2;}
            else if (temp[1].equals("*")){ sum = num1 * num2;}
            else if (temp[1].equals("/")) {
                if (num2 == 0) {
                    String str2 = "It cannot be divided by zero !!! \n";
                    outputStream.writeBytes(str2);
                } else {
                    sum = num1 / num2;
                }
            }
            else { System.out.println("Please Enter valid operation!!!");}

            if (num2 != 0) {
                String str2 = sum + "\n";
                outputStream.writeBytes(str2);
            }

            System.out.println("Output Send ....");

        }
        } catch (IOException e) {
            System.out.println("Server => "+e.getMessage());
            e.printStackTrace();
        }
    }
}
