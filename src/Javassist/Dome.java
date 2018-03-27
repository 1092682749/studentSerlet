package Javassist;

import javassist.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Dome {
    public static void main(String args[]) throws CannotCompileException, NotFoundException, IOException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.makeClass("Test");

        CtField f1 = CtField.make("private String name;",cc);
        cc.addField(f1);

        CtMethod m1 = CtMethod.make("public void setName(String name){this.name=name;System.out.println(name);}",cc);
        cc.addMethod(m1);

//        CtConstructor constructor = new CtConstructor(new CtClass[]{},cc);
//        constructor.setBody("this.name = $1;");
//        cc.addConstructor(constructor);

        cc.writeFile("i://c#");

        //反射代码开始
        Class<?> clazz = cc.toClass();
        Object o = clazz.newInstance();
        Method m = o.getClass().getDeclaredMethod("setName",String.class);
        m.invoke(o,"qwe");
    }
}
