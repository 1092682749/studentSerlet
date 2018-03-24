package classLoder;

public class dome {
    public static void main(String args[])
    {
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        dome d = new dome();
        System.out.println(d.getClass().getClassLoader());
        System.out.println(String.class.getClassLoader());
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
    }
}

