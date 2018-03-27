package dynamicCondition;

import org.junit.Test;

public class Dome2 {
    @Test
    public void test()
    {
        CGLIBCondition cglibCondition = new CGLIBCondition();
        HelloWorldImp helloWorldImp = (HelloWorldImp)cglibCondition.getProxy(HelloWorldImp.class);
        helloWorldImp.sayHello();
    }
}
