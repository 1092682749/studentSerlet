package dynamicCondition;

import java.lang.reflect.Method;

public class Interceptor1 implements Interceptor {
    @Override
    public boolean before(Object proxy, Object target, Method method, Object[] objects) {
        System.out.println("我是第一个代理者的before");
        return true;
    }

    @Override
    public void around(Object proxy, Object target, Method method, Object[] objects) {
        System.out.println("我是第一个代理者的around");
    }

    @Override
    public void after(Object proxy, Object target, Method method, Object[] objects) {
        System.out.println("我是第一个代理者的after");
    }
}
