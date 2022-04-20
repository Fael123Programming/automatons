package classes;

import java.util.Map;
import java.util.HashMap;

import exceptions.InitialStateNotFoundException;
import exceptions.StateNotFoundException;
import exceptions.UnrecognizedSymbolException;

public class Automaton {
    private final Map<String, State> states;
    private final String alphabet;

    {
        states = new HashMap<>();
    }

    public Automaton(String alphabet) {
        this.alphabet = alphabet;
    }

    public State addState(String name, boolean acceptanceState, boolean initialState) {
        State newState = new State(name, acceptanceState, initialState);
        states.put(name, newState);
        return newState;
    }

    public State state(String name) {
        return states.get(name);
    }

    public boolean isValidChain(String chain) {
        return eval(chain).isAcceptanceState();
    }

    public State evaluate(String chain) {
        return eval(chain);
    }

    private Automaton.State eval(String chain) {
        char currentChar;
        State currentState = getInitialState();
        for (int i = 0; i < chain.length(); i++) {
            currentChar = chain.charAt(i);
            checkValidSymbol(currentChar);
            currentState = currentState.getLinkedState(currentChar);
            //currentChar does not belong to the alphabet.
        }
        return currentState;
    }

    private State getInitialState() {
        for (State s : states.values()) {
            if (s.isInitialState()) {
                return s;
            }
        }        
        throw new InitialStateNotFoundException();
    }

    private void checkValidSymbol(char symbol) throws UnrecognizedSymbolException {
        if (notValidSymbol(symbol)) {
            throw new UnrecognizedSymbolException(symbol);
        }
    }

    private boolean notValidSymbol(char symbol) {
        return !this.alphabet.contains(Character.toString(symbol));
    }

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

        public State linkTo(char index, String otherState) {
            State toLinkTo = Automaton.this.states.get(otherState);
            if (toLinkTo == null) {
                throw new StateNotFoundException(otherState);
            }
            this.linkedStates.put(index, toLinkTo);
            return this;
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
}