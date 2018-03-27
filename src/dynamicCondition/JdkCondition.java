package dynamicCondition;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkCondition implements InvocationHandler {
    private Object target = null;
    public Object bind(Object targer)
    {
        this.target = targer;
        return Proxy.newProxyInstance(targer.getClass().getClassLoader(),targer.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进入代理方法！");
        System.out.println("调度真实方法之前的逻辑");
        Object obj = method.invoke(target,args);
        System.out.println("真实方法之后的逻辑");
        return obj;
    }
}