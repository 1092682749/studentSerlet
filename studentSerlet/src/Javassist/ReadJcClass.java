package Javassist;

import java.io.*;

public class ReadJcClass {
    public static void main(String args[]) throws IOException {
        File file = new File("i://c#/abc/JCCtlass.class");
        BufferedInputStream bi = new BufferedInputStream(new FileInputStream(file));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

        String str = "";
        String stmp = null;
        byte[] b = new byte[1024];
        int i;
//        while((stmp=br.readLine())!=null)
//        {
//            System.out.println(stmp);
//        }
        while((i=bi.read(b))!=-1)
        {
            str += new String(b,"utf-8");
        }
        System.out.println(str);
    }
}
