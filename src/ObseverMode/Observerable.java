package ObseverMode;

public interface Observerable {
     public void addObserver(Observer o);
     public void removeOberver(Observer o);
     public void notifyOberser();
}
