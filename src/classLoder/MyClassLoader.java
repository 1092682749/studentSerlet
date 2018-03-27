package classLoder;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MyClassLoader extends ClassLoader {
    String rootDir;
    MyClassLoader(String rootDir)
    {
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> c = findLoadedClass(name);
        if (c!=null)
        {
            return c;
        }else{
            ClassLoader parent = this.getParent();
            try {
                c = parent.loadClass(name);
            }catch (Exception e)
            {

            }
            if (c!=null)
            {
                return c;
            }else {
                byte[] classData = new byte[0];
                try {
                    classData = getClassData(name);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (classData==null)
                {
                    throw new ClassNotFoundException();
                }else {
                    c = defineClass(name,classData,0,classData.length);
                    return  c;
                }
            }
        }
    }

    private byte[] getClassData(String name) throws IOException {
        String path = rootDir + "/" + name + ".class";
        FileInputStream fis = new FileInputStream(path);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len=0;
        while((len=fis.read(buffer))!=-1)
        {
            baos.write(buffer,0,len);
        }
        return baos.toByteArray();
    }
}
