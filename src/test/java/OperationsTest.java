

import dev.mars.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OperationsTest {

    @Test
    public void givenOperation_whenStateSet_thenStateNameRetrieved() {
        var validationState = new ValidationState("Validation State");
        Operation op = new Operation(validationState);
        assertEquals("Validation State", op.getStatus());
    }

    @Test
    public void givenOperation_whenStateSet_thenNestStateFalse() {
        var validationState = new ValidationState("Validation State");
        Operation op = new Operation(validationState);

        assertFalse(op.hasNextState());
    }

    @Test
    public void givenOperation_whenNextStateNotSet_thenThrowNoNextStateException() {
        var validationState = new ValidationState("Validation State");
        Operation op = new Operation(validationState);
        assertThrows(UnsupportedOperationException.class, op::nextState);
    }



    @Test
    public void givenNewOperation_whenOperationValidated_thenStateCompleted() {
        var validationState = new ValidationState("Validation State");
        var confirmationState = new ConfirmationState("Confirmation State");
        var bookingState = new BookingState("Booking State");
        var completedState = new CompletedState("Completed State");
        validationState.setNextState(confirmationState);
        confirmationState.setPrevState(validationState);
        confirmationState.setNextState(bookingState);
        bookingState.setPrevState(confirmationState);
        bookingState.setNextState(completedState);
        completedState.setPrevState(bookingState);

        Operation op = new Operation(validationState);

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
        var validationState = new ValidationState("Validation State");
        var confirmationState = new ConfirmationState("Confirmation State");
        confirmationState.setPrevState(validationState);
        validationState.setNextState(confirmationState);

        Operation op = new Operation(validationState);

        op.nextState();

        assertTrue(op.getState() instanceof ConfirmationState);
        op.previousState();

        assertTrue(op.getState() instanceof ValidationState);

    }

    @Test
    public void givenOperationCompleted_whenNextState_thenStateCompleted() {
        var validationState = new ValidationState("Validation State");
        var completedState = new CompletedState("Completed State");
        validationState.setNextState(completedState);
        completedState.setPrevState(validationState);
        completedState.setNextState(completedState);

        Operation op = new Operation(validationState);

        op.nextState();

        assertTrue(op.getState() instanceof CompletedState);
        op.nextState();

        assertTrue(op.getState() instanceof CompletedState);

    }

    @Test
    public void givenOperation_whenGetStatus_thenCorrectStatus() {
        var validationState = new ValidationState("Validation State");
        var confirmationState = new ConfirmationState("Confirmation State");
        var bookingState = new BookingState("Booking State");
        var completedState = new CompletedState("Completed State");

        validationState.setNextState(confirmationState);
        confirmationState.setPrevState(validationState);
        confirmationState.setNextState(bookingState);
        bookingState.setPrevState(confirmationState);
        bookingState.setNextState(completedState);
        completedState.setPrevState(bookingState);

        Operation op = new Operation(validationState);

        // Initial state
        assertEquals("Validation State", op.getStatus());

        // Transition to next state
        op.nextState();
        assertEquals("Confirmation State", op.getStatus());

        // Transition to next state
        op.nextState();
        assertEquals("Booking State", op.getStatus());

        // Transition to next state
        op.nextState();
        assertEquals("Completed State", op.getStatus());
    }




    @Test
    public void givenOperation_whenPrevStateNotSet_thenThrowNoPrevStateException() {
        var validationState = new ValidationState("Validation State");
        Operation<Trade> op = new Operation<>(validationState);
        assertThrows(UnsupportedOperationException.class, op::previousState);
    }

    @Test
    public void givenOperation_whenPerformAction_thenActionPerformed() {
        var validationState = new ValidationState("Validation State");
        Operation<Trade> op = new Operation<>(validationState);
        Trade trade = new Trade("Trade 1", "ABC Ltd", 1000);
        assertTrue(op.performAction(trade));
    }

    @Test
    public void givenOperation_whenSetState_thenStateIsSet() {
        var validationState = new ValidationState("Validation State");
        var confirmationState = new ConfirmationState("Confirmation State");
        Operation<Trade> op = new Operation<>(validationState);
        op.setState(confirmationState);
        assertEquals("Confirmation State", op.getStatus());
    }
}

