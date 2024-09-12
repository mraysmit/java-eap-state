package test.mars;

import mars.dev.Operation;
import mars.dev.state.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OperationsTest {

    @Test
    public void givenNewOperation_whenOperationValidated_thenStateCompleted() {
        Operation op = new Operation();

        assertTrue(op.getState() instanceof ValidationState);
        op.nextState();

        assertTrue(op.getState() instanceof ConfirmationState);
        op.nextState();

        assertTrue(op.getState() instanceof BookingState);
        op.nextState();

        assertTrue(op.getState() instanceof CompletedState);
    }

    @Test
    public void givenOperationBooking_whenPrevState_thenStateConfirmation() {
        Operation op = new Operation();

        op.setState(new ConfirmationState());

        assertTrue(op.getState() instanceof ConfirmationState);
        op.previousState();

        assertTrue(op.getState() instanceof ValidationState);

    }

    @Test
    public void givenOperationCompleted_whenNextState_thenStateCompleted() {
        Operation op = new Operation();

        op.setState(new CompletedState());

        assertTrue(op.getState() instanceof CompletedState);
        op.nextState();

        assertTrue(op.getState() instanceof CompletedState);

    }

    @Test
    public void givenOperation_whenGetStatus_thenCorrectStatus() {
    Operation op = new Operation();

    // Initial state
    assertEquals("Validation state", op.getStatus());

    // Transition to next state
    op.nextState();
    assertEquals("Confirmation state", op.getStatus());

    // Transition to next state
    op.nextState();
    assertEquals("Booking state", op.getStatus());

    // Transition to next state
    op.nextState();
    assertEquals("Completed state", op.getStatus());
}

}
