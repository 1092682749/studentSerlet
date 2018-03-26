package ObseverMode;

import org.junit.Test;

public class Dome {
    @Test
    public void test()
    {
        ObserverableImp observerableImp = new ObserverableImp();
        Observer observer1 = new ObserverImp();
        Observer observer2 = new ObserverImp();
        observerableImp.addObserver(observer1);
        observerableImp.addObserver(observer2);
        observerableImp.setObj("String");
    }
}
