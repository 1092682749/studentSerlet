package aaa;

import java.net.Socket;

public class Dispatcher implements Runnable{
    private int code=200;
    private Response resp;
    private Request req;
    private Socket socket;
    Dispatcher(Socket socket)
    {
        this.socket = socket;
        this.req = new Request(this.socket);
        this.resp = new Response(this.socket);
    }

    @Override
    public void run() {
        Servlet servlet = new Servlet();
        servlet.service(req,resp);
        resp.pushToClient(code);
    }
}
