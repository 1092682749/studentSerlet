package Javassist;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtNewMethod;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Dome2 {
    public static void main(String args[]){
        try {
            ClassPool pool = ClassPool.getDefault();
            CtClass   cc   = pool.makeClass("Test");
            CtField ctField = CtField.make("private String name;", cc);
            cc.addField(ctField);
            cc.addMethod(CtNewMethod.make("public void setName(String name){System.out.println(name); this.name = name;}", cc));
            Object target = cc.toClass().newInstance();
            Method method = target.getClass().getDeclaredMethod("setName", String.class);
            method.invoke(target, "Hello");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
