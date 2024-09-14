package mars.dev.state;

import mars.dev.Operation;
import mars.dev.State;
import mars.dev.Trade;

public class ValidationState extends AbstractState {

    public ValidationState(String stateName) {
        super(stateName);
    }

    @Override
    public boolean performAction(Trade context) {
        return false;
    }

    @Override
    public void next(Operation op) {
        op.setState(nextState);
    }
    @Override
    public void prev(Operation op) {
        throw new UnsupportedOperationException("Already in first state.");
    }
}


