// State.java
package mars.dev;

public interface State<T> {
    boolean performAction(T context);
    void setNextState(State<T> nextState);
    void setPrevState(State<T> prevState);
    void next(Operation<T> op);
    void prev(Operation<T> op);
    boolean hasNextState();
    boolean hasPrevState();
    String getStatus();
}