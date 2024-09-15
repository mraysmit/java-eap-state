package mars.dev.state;

import mars.dev.Operation;
import mars.dev.Trade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class CompletedState extends AbstractState {
    Logger logger = LogManager.getLogger(CompletedState.class);

    public CompletedState(String stateName) {
        super(stateName);
    }

    @Override
    public boolean performAction(Trade context) {
        logger.info("Performing action on CompletedState");
        return true;
    }


}