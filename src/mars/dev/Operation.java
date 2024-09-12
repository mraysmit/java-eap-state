
package mars.dev;

import mars.dev.state.ValidationState;

public class Operation {

    private State state = new ValidationState();

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
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

}
