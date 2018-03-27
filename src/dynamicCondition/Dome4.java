package dynamicCondition;

import org.junit.Test;

public class Dome4 {
    @Test
    public void test()
    {
        HelloWorld proxy1 = (HelloWorld) InterceptorJDKProxy.bind(new HelloWorldImp(),"dynamicCondition.Interceptor1");
        HelloWorld proxy2 = (HelloWorld) InterceptorJDKProxy.bind(proxy1,"dynamicCondition.Interceptor2");
        HelloWorld proxy3 = (HelloWorld)InterceptorJDKProxy.bind(proxy2,"dynamicCondition.Interceptor3");
        proxy3.sayHello();
    }
}
