package dev.mars;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ValidationState extends AbstractState {
    private final Logger logger = LogManager.getLogger(ValidationState.class);

    public ValidationState(String stateName) {
        super(stateName);
    }

    @Override
    public boolean performAction(Trade context) {
        logger.info("Performing action on ValidationState");
        return true;
    }



}


