package ObseverMode;

public class ObserverImp implements Observer {
    @Override
    public void updata(Object o) {
        System.out.println("观察结果："+o.toString());
    }
}
