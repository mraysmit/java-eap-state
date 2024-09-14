// src/mars/dev/state/AbstractState.java
package mars.dev.state;

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
}