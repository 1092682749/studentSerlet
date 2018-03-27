package classLoder;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class testClassLoader {
    public static void main(String args[])
    {
        MyClassLoader classLoader = new MyClassLoader("I:/新建文件夹1/java");
        try {
            Class<?> c = classLoader.findClass("java1");
            Object o = c.getDeclaredConstructor().newInstance();
            System.out.println(c.getClassLoader());
            Method m = c.getDeclaredMethod("main",String[].class);
            m.invoke(o, (Object)new String[]{});
            //m.invoke(null, (Object)new String[]{});会编译成:m.invoke(null,"aa","bb"),就发生了参数个数不匹配的问题。
            //因此，必须要加上(Object)转型，避免这个问题。
            //public static void main(String[] args)
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
