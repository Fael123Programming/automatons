package classes;

import java.util.ArrayList;
import java.util.List;

import exceptions.InitialStateNotFoundException;
import exceptions.UnrecognizedSymbolException;

public class Automaton {
    private final List<State> states;

    {
        states = new ArrayList<>();
    }

    public Automaton(State... states) {
        if (states == null) {
            throw new IllegalArgumentException("states cannot be null");
        }
        for (State s : states) {
            if (s == null) {
                throw new IllegalArgumentException("cannot have a null state");
            }
            this.states.add(s);
        }
    }
    
    public void addState(State state) {
        states.add(state);
    }

    public State getState(int position) {
        return states.get(position);
    }

    public boolean isValidChain(String chain) {
        return eval(chain).isAcceptanceState();
    }

    public State evaluate(String chain) {
        return eval(chain);
    }

    private State eval(String chain) {
        char currentChar;
        State currentState = getInitialState();
        for (int i = 0; i < chain.length(); i++) {
            currentChar = chain.charAt(i);
            currentState = currentState.getLinkedState(currentChar);
            //currentChar does not belong to the alphabet.
            if (currentState == null) {
                throw new UnrecognizedSymbolException(currentChar);
            }
        }
        return currentState;
    }

    private State getInitialState() {
        for (State s : states) {
            if (s.isInitialState()) {
                return s;
            }
        }        
        throw new InitialStateNotFoundException();
    }
}