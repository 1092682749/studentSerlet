package classLoder;

public class ReadEncrype {
    public static void main(String args[]) throws ClassNotFoundException {
        MyClassLoader classLoader = new MyClassLoader("I:/新建文件夹1/java/subdir");
        Class clazz = classLoader.findClass("java1");
        System.out.print(clazz.getClassLoader());
    }
}
