package classLoder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Encrypt {
    private FileInputStream in;
    private FileOutputStream out;
    Encrypt(String inPath,String outPath)
    {
        try {
            in = new FileInputStream(inPath);
            out = new FileOutputStream(outPath);
            int isend;
            while((isend=in.read())!=-1)
            {
                out.write(isend^0xff);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e)
        {
            e.printStackTrace();
        }finally{
            if (in!=null)
            {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out!=null)
            {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
