import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import static java.lang.System.out;

public class Client {
    public static String start (int serverPort, String command) {
        BufferedReader fromServer;
        String str = "";
        try (Socket socket = new Socket("127.0.0.1", serverPort)) {
            socket.setSoTimeout(20000);
            try (PrintWriter toServer = new PrintWriter(socket.getOutputStream(), true)) {
                // Отправка данных на сервер
                String line = command + " " + serverPort + "\n";
                toServer.println(line);
                // Ответ сервера
                fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                str = fromServer.readLine();
                System.out.println(str);
            }
            fromServer.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
