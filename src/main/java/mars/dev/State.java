package mars.dev;

public interface State<T> {
    boolean performAction(T context);
    void setNextState(State nextState);
    void setPrevState(State prevState);
    void next(Operation op);
    void prev(Operation op);
    String getStatus();
}