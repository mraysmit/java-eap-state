package mars.dev;

import mars.dev.state.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    public static void main(String[] args) {
        final Logger log = LogManager.getLogger(Main.class);

        log.info("info message");

        Trade trade = new Trade("Trade 1", "ABC Ltd", 1000);
        log.info(trade.toString());

        Operation<Trade> firstOperation = configureFirstOperation();

        log.info(firstOperation.getStatus()); // Prints the status after transitioning to the next state

        while (firstOperation.hasNextState())  {
            firstOperation.performAction(trade); // Prints the action performed by the current state
            firstOperation.nextState();
            log.info(firstOperation.getStatus()); // Prints the status after transitioning to the next state
        };

//        firstOperation.performAction(trade); // Prints the action performed by the current state

//        firstOperation.nextState();
//        log.info(firstOperation.getStatus()); // Prints the status after transitioning to the next state
//
//        firstOperation.nextState();
//        log.info(firstOperation.getStatus()); // Prints the status after transitioning to the next state
//
//        firstOperation.nextState();
//        log.info(firstOperation.getStatus()); // Prints the status after transitioning to the next state
    }





    private static Operation<Trade> configureFirstOperation() {
        // An example of configuring an Operation with a chain of states
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

        return new Operation(validationState);
    }
}