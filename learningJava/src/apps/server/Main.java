package apps.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8089);
        Set<Socket> clients = new HashSet<>();
        while (true) {
            Socket accept = serverSocket.accept();
            new Thread(() -> {
                try {
                    InputStream inputStream = accept.getInputStream();
                    OutputStream outputStream = accept.getOutputStream();
                    outputStream.write("hello".getBytes());
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    clients.add(accept);
                    while (true) {
                        String line = bufferedReader.readLine();
                        for (Socket socket : clients) {
                            if (accept != socket)
                                socket.getOutputStream().write(((line + "\n\r").getBytes()));
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }).start();
        }
    }
}
