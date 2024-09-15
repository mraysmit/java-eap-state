// Operation.java
package mars.dev;

public class Operation<T> {
    private State<T> state;

    public Operation(State<T> state) {
        this.state = state;
    }

    public void setState(State<T> state) {
        this.state = state;
    }

    public void previousState() {
        state.prev(this);
    }

    public void nextState() {
        state.next(this);
    }

    public String getStatus() {
        return state.getStatus();
    }

    public State<T> getState() {
        return state;
    }

    public boolean performAction(T context) {
        return state.performAction(context);
    }

    public boolean hasNextState() {
        return state.hasNextState();
    }
}