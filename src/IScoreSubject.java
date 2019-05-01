
public interface IScoreSubject  
{
    void attach (IScoreObserver obj);

    void removeObserver (IScoreObserver obj);

    void notifyObservers();
}
