package mars.dev.state;

import mars.dev.Operation;
import mars.dev.State;

public class BookingState implements State {

    public void next(Operation op) {
        op.setState(new CompletedState());
    }

    public void prev(Operation op) {
        op.setState(new ConfirmationState());
    }

    public String getStatus() {
        return "Booking state";
    }
}
