// src/mars/dev/state/AbstractState.java
package mars.dev.state;

import mars.dev.Operation;
import mars.dev.State;
import mars.dev.Trade;

public abstract class AbstractState implements State<Trade> {
    protected final String stateName;
    State nextState;
    State prevState;

    public AbstractState(String stateName) {
        this.stateName = stateName;
    }

    @Override
    public String getStatus() {
        return stateName;
    }

    @Override
    public void setNextState(State nextState) {
        this.nextState = nextState;
    }

    @Override
    public void setPrevState(State prevState) {
        this.prevState = prevState;
    }

    @Override
    public boolean hasNextState() {
        return nextState != null;
    }
    @Override
    public boolean hasPrevState() {
        return prevState != null;
    }

    @Override
    public void next(Operation<Trade> op) {
        if (nextState != null) {
            op.setState(nextState);
        } else {
            throw new UnsupportedOperationException("No next state defined.");
        }
    }

    @Override
    public void prev(Operation<Trade> op) {
        if (prevState != null) {
            op.setState(prevState);
        } else {
            throw new UnsupportedOperationException("No previous state defined.");
        }
    }
}