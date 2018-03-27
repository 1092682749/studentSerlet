package classLoder;

public class TestEncrypt {
    public static void main(String args[]) throws ClassNotFoundException {
//        Encrypt encryptClass = new Encrypt("I:/新建文件夹1/java/java1.class","I:/新建文件夹1/java/subdir/java1.class");
        EncrypeClassLoader classLoader = new EncrypeClassLoader("I:/新建文件夹1/java/subdir");
//        EncrypeClassLoader classLoader = new EncrypeClassLoader("I:/新建文件夹1/java");
        Class<?> clazz = classLoader.findClass("java1");
        System.out.println(clazz.getClassLoader());
    }
}
