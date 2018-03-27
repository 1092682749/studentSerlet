package ObseverMode;

import java.util.ArrayList;
import java.util.List;

public class ObserverableImp implements Observerable {
    List<Observer> observers = new ArrayList<Observer>();
    Object obj;
    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeOberver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyOberser() {
        for (Observer o : observers)
        {
            o.updata(obj);
        }
    }
    public void setObj(Object obj)
    {
        this.obj = obj;
        notifyOberser();
    }
}
