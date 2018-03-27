package aaa;

import com.mysql.fabric.xmlrpc.base.Data;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {
    private ServerSocket serverSocket;
    public void start() throws IOException {
        serverSocket = new ServerSocket(8000);
        while(true)
        {
            Socket socket = serverSocket.accept();
            ServerThread serverThread = new ServerThread(socket);
            serverThread.start();
        }
    }
//    public void accpet()
//    {
//        try {
//
////            InputStream in = socket.getInputStream();
////            System.out.println(in.read());
////            BufferedInputStream bi = new BufferedInputStream(in);
////            System.out.println(bi.read());
////            byte[] readByte = new byte[1024];
////            int len = 0;
////            while((len=bi.read(readByte))!=-1)
////            {
////                System.out.println(readByte.toString());
////            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    public static void  main(String args[])
    {
        Server myServer = new Server();
        try {
//            InputStreamReader in = new InputStreamReader(new BufferedInputStream(System.in));
//            String  a = (String) in.read();
//            System.out.println(a);
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            String str = br.readLine();
//            System.out.println(str);
            myServer.start();
//            myServer.accpet();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class ServerThread extends Thread{
    Socket socket;
    ServerThread(Socket socket)
    {
        this.socket = socket;
    }

    @Override
    public void run() {

//            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            String str;
//            while((str=br.readLine())!=null)
//            {
//                System.out.println(str);
//            }
//            System.out.println("这是一个客户端");
//            BufferedInputStream bin = new BufferedInputStream(socket.getInputStream());
//            StringBuffer stringBuffer = new StringBuffer();
//            stringBuffer.append()
//            byte[] inputByte = new byte[10240];
//            while((bin.read(inputByte))!=-1)
//            {
//                stringBuffer.append(inputByte);
//            }
//            System.out.println(stringBuffer);
//            int len = socket.getInputStream().read(inputByte);
//
//            String str = new String(inputByte,0,len);
//            System.out.println(str);
//
//            //响应
//            String CRLF = "\r\n";
//            String BLANK = " ";
//            String contenText = "<html><head><title></title></head><body>123</body></html>";
//            StringBuffer stringBuffer = new StringBuffer();
//
//            stringBuffer.append("HTTP/1.1").append(BLANK).append("200").append(BLANK).append("OK").append(CRLF);
//            stringBuffer.append("Server:bjsxt Server/0.0.1").append(CRLF);
//            stringBuffer.append("Date:"+new Date()).append(CRLF);
//            stringBuffer.append("Content-type:text/html;charset=GBK").append(CRLF);
//            stringBuffer.append("Centent-Length:").append(contenText.getBytes().length).append(CRLF);
//            stringBuffer.append(CRLF);
//            stringBuffer.append(contenText);
//            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//            bw.write(stringBuffer.toString());
//            System.out.println(stringBuffer.toString());
//            bw.flush();
//            bw.close();
            Request request = new Request(socket);
//            request.analysisRequestParam();
            String parameter = request.getParameter("name");
            String[] parameters = request.getParameters("interest");
            System.out.println("兴趣种类："+parameters.length);
            for(String str:parameters)
            {
                System.out.println("兴趣编号:"+str);
            }
          System.out.println(parameter);

            Response response = new Response(socket);
            response.println("<html><head><title></title></head><body>123</body></html>");
            response.pushToClient(200);
            response.close();
    }
}

