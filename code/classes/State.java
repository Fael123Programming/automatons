package classes;

import java.util.Map;
import java.util.HashMap;

public class State {
    private final Map<Character, State> linkedStates;
    private final boolean isAcceptanceState, isInitialState;
    private final String name;

    {
        linkedStates = new HashMap<>();
    }

    public State(String name, boolean isAcceptanceState, boolean isInitialState) {
        this.name = name;
        this.isAcceptanceState = isAcceptanceState;
        this.isInitialState = isInitialState;
    }

    public State getLinkedState(char index) {
        return linkedStates.get(index);
    }

    public void setLinkedState(char index, State state) {
        linkedStates.put(index, state);
    }

    public boolean isAcceptanceState() {
        return isAcceptanceState;
    }

    public boolean isInitialState() {
        return isInitialState;
    }

    @Override
    public String toString() {
        return name;
    }
}
