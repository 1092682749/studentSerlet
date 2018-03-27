package aaa;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
    ServerSocket serverSocket;
    private boolean isShutDown = false;
    public void start() throws IOException {
        serverSocket = new ServerSocket(8000);
        this.receive();
    }
    public void receive()
    {
        while(!isShutDown)
        {
            try {

                new Thread(new Dispatcher(serverSocket.accept())).start();
            } catch (IOException e) {
                e.printStackTrace();
                stop();
            }
        }
    }
    public void stop()
    {
        isShutDown = true;
    }
    public static void main(String args[])
    {
        try {
            new Server2().start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
