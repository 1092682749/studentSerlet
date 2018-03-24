package classLoder;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

public class EncrypeClassLoader extends ClassLoader {
    String rootDir;
    EncrypeClassLoader(String rootDir)
    {
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] b = getClassDate(name);
        if (b == null)
        {
            throw new NullPointerException();
        }
        Class<?> c = defineClass(name,b,0,b.length);
        return c;
    }
    public byte[] getClassDate(String name)
    {
        String path = rootDir+"/"+name+".class";
        FileInputStream in;
        ByteArrayOutputStream out=null;
        try{
            in = new FileInputStream(path);
            out = new ByteArrayOutputStream();
            byte[] b = new byte[10240];
            int len = 0;
            while((len=in.read())!=-1)
            {
                out.write(len^0xff);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return out.toByteArray();
    }
}
