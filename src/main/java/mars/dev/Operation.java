package mars.dev;

public class Operation {
    private State state;

    public Operation(State state) {
        this.state = state;
    }

    public void setState(State state) {
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

    public State getState() {
        return state;
    }

}
