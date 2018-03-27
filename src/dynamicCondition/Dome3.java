package dynamicCondition;

import org.junit.Test;

public class Dome3 {
    @Test
    public void test()
    {
        HelloWorld helloWorld = (HelloWorld)InterceptorJDKProxy.bind(new HelloWorldImp(),"dynamicCondition.MyInterceptor");
        helloWorld.sayHello();
    }
}
