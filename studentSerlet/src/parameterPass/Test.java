package parameterPass;

public class Test {
    String s = "start";
    public void add(int i)
    {
         i++;
    }
    public void changeObject(Test t,String ss)//虽然两者都是引用传递，但是在改变值时发生了不同的变化
    {
        t.s += "end";//改变该对象的属性，因为是引用传递所以改变的就是实参的属性
        ss += "end";//相当于ss和“end”拼接成一个新的对象赋值给ss，此时的ss指向新的对象，和原来的对象无关（可以理解为ss
        //不再是实参的引用而是一个新的局部变量// ）
    }
    public static void main(String args[])
    {
        Test t = new Test();
        int i = 1;
        t.add(i);
        String ss = "123";
        t.changeObject(t,ss);
        System.out.println(i);
        System.out.println(t.s);
        System.out.println(ss);
    }
}
