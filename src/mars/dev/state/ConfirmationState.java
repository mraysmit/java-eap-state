package mars.dev.state;

import mars.dev.Operation;
import mars.dev.State;

public class ConfirmationState implements State {

    public void next(Operation op) {
        op.setState(new BookingState());
    }

    public void prev(Operation op) {
        op.setState(new ValidationState());
    }

    public String getStatus() {
        return "Confirmation state";
    }
}
