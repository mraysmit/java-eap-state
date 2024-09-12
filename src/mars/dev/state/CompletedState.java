package mars.dev.state;

import mars.dev.Operation;
import mars.dev.State;

public class CompletedState implements State {

    @Override
    public void next(Operation op) {
        System.out.println("Already in last state.");
    }

    @Override
    public void prev(Operation op) {
        op.setState(new ConfirmationState());
    }

    @Override
    public String getStatus() {
        return "Completed state";
    }
}
