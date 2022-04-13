package classes;

import java.util.Map;
import java.util.HashMap;

public class State {
    private final Map<Character, State> linkedStates;
    private final boolean acceptanceState, initialState;
    private final String name;

    {
        linkedStates = new HashMap<>();
    }

    public State(String name) {
        this.name = name;
        this.acceptanceState = false;
        this.initialState = false;
    }

    public State(String name, boolean acceptanceState, boolean initialState) {
        this.name = name;
        this.acceptanceState = acceptanceState;
        this.initialState = initialState;
    }

    public State getLinkedState(char index) {
        return linkedStates.get(index);
    }

    public void setLinkedState(char index, State state) {
        linkedStates.put(index, state);
    }

    public boolean isAcceptanceState() {
        return acceptanceState;
    }

    public boolean isInitialState() {
        return initialState;
    }

    @Override
    public String toString() {
        return name;
    }
}
