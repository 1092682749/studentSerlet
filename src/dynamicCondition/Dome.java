package dynamicCondition;

import org.junit.Test;

public class Dome {
    @Test
    public void test()
    {
        JdkCondition jdkCondition = new JdkCondition();
        HelloWorld helloWorld = (HelloWorld) jdkCondition.bind(new HelloWorldImp());
        helloWorld.sayHello();
    }
}
