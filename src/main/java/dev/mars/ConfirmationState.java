package dev.mars;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConfirmationState extends AbstractState {
    private final Logger logger = LogManager.getLogger(ConfirmationState.class);

    public ConfirmationState(String stateName) {
        super(stateName);
    }

    @Override
    public boolean performAction(Trade context) {
        logger.info("Performing action on ConfirmationState");
        return true;
    }



}