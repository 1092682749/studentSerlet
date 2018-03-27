package aaa;

//import com.sun.javafx.collections.MappingChange;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.*;
import java.util.List;

public class Request {
    private String method;
    private String url;
    private Map<String,List<String>> paramMap;
    public static final String CRLF = "\r\n";
    private InputStream in;
    private String requestInfo;
    private Request()
    {
        method=" ";
        url=" ";
        paramMap = new HashMap<String,List<String>>();
        requestInfo="";
    }
    Request(Socket socket)
    {
        this();
        try {
            this.in = socket.getInputStream();
            byte[] readByte = new byte[10240];
            int len = in.read(readByte);
            requestInfo = new String(readByte,0,len);
            System.out.println("请求信息是："+requestInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        analysisRequestParam();
    }
    Request(InputStream in)
    {
        this();
        this.in=in;
        try{
            byte[] readByte = new byte[10240];
            int len = in.read(readByte);
            requestInfo = new String(readByte,0,len);
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        analysisRequestParam();
    }
    public void analysisRequestParam()
    {
        if (requestInfo.equals(" "))
        {
            return;
        }
        String firstLine = requestInfo.substring(0,requestInfo.indexOf(CRLF));
        method = firstLine.substring(0,firstLine.indexOf("/")).trim();
        String paramUrl = firstLine.substring(firstLine.indexOf("/"),firstLine.indexOf("HTTP/1.1"));
        if(paramUrl.contains("?"))
        {
            String[] arryStr = paramUrl.split("\\?");
            url = arryStr[0].trim();
            String paramString = arryStr[1].trim();
//            System.out.println(method+"\n"+url+"\n"+paramString);
            ananlysisParamString(paramString);
        }
    }

    private void ananlysisParamString(String paramString) {
        if (paramString.equals(""))return;
        StringTokenizer tokenizer = new StringTokenizer(paramString,"&");
        while (tokenizer.hasMoreTokens())
        {
            String keyValue = tokenizer.nextToken();
            String param[] = keyValue.split("=");
            String key = null;
            String value = null;
            try {
                key = new String(param[0].getBytes(),"utf-8");
                value = new String(param[1].getBytes(),"utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
//            System.out.println("key is:"+key+"\n"+"value is:"+value);
            if(!paramMap.containsKey(key)){
                paramMap.put(key,new ArrayList<String>());
            }
            List<String> values=  paramMap.get(key);
            values.add(value);
        }
    }
    public String getParameter(String name) {
        if (paramMap.get(name) == null) {
            System.out.println("没有数据");
            return null;
        } else {
            return paramMap.get(name).get(0);
        }
    }
    public String[] getParameters(String name)
    {
        List<String> values = paramMap.get(name);
        if (values==null)return null;
        else{
            return values.toArray(new String[0]);
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static void main(String args[])
    {
//       Request request =  new Request();
        Dimension dimension = new Dimension();
        dimension.setSize(100,100);
        Frame frame = new Frame();
        Panel panel = new Panel(){
            @Override
            public void paint(Graphics g) {
                g.setColor(Color.BLACK);
                Rectangle rectangle = new Rectangle();
                Rectangle rectangle1 = new Rectangle(50,50,100,100);
                rectangle.setLocation(100,100);
                rectangle.setSize(dimension);
//        g.drawRect(100,100,(int)dimension.getWidth(),(int)dimension.getHeight());
//        g.drawRect(50,50,50,50);
                g.drawLine(0,0,100,100);
                g.drawRect(rectangle.x,rectangle.y,rectangle.width,rectangle.height);
                g.drawRect(rectangle1.x,rectangle1.y,rectangle1.width,rectangle1.height);
                if(rectangle.intersects(rectangle1))
                {
                    System.out.println("香蕉了");
                }
            }
        };
//        Graphics g = frame.getGraphics();

//        System.out.println(rectangle.x+" "+rectangle.width);
        frame.add(panel);
        frame.setSize(500,500);
        frame.setVisible(true);
    }
}
