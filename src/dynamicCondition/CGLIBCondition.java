package dynamicCondition;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLIBCondition implements MethodInterceptor {
    public Object getProxy(Class cla)
    {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(cla);
        enhancer.setCallback(this);
        return enhancer.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("进入拦截方法内部");
        System.out.println("调用真实方法之前的逻辑");
        Object result = methodProxy.invokeSuper(o,objects);
        System.out.println("调用真实方法之后");
        return result;
    }
}
