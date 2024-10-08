package dev.mars;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BookingState extends AbstractState {
    Logger logger = LogManager.getLogger(BookingState.class);

    public BookingState(String stateName) {
        super(stateName);
    }

    @Override
    public boolean performAction(Trade context) {
        logger.info("Performing action on BookingState");
        return true;
    }


}