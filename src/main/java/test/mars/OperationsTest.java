package test.mars;

import mars.dev.Operation;
import mars.dev.state.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OperationsTest {

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

}
