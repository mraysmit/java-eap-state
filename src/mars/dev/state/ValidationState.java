package mars.dev.state;

import mars.dev.Operation;
import mars.dev.State;

public class ValidationState implements State {

    @Override
    public void next(Operation op) {
        op.setState(new ConfirmationState());
    }

    @Override
    public void prev(Operation op) {
        System.out.println("Already in first state.");
    }

    @Override
    public String getStatus() {
        return "Validation state";
    }
}
