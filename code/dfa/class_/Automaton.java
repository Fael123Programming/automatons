package dfa.class_;

import java.util.Map;
import java.util.HashMap;

import dfa.exceptions.IndefiniteMappingException;
import dfa.exceptions.InitialStateNotFoundException;
import dfa.exceptions.UnrecognizedSymbolException;

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
            currentState = this.states.get(currentState.getLinkedStateName(currentChar));
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

    public static class State {
        private final Map<Character, String> linkedStates;
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

        public String getLinkedStateName(char symbol) throws IndefiniteMappingException {
            String stateName = linkedStates.get(symbol);
            if (stateName == null) {
                throw new IndefiniteMappingException(symbol, this.name);
            }
            return stateName;
        }

        public State linkTo(String nameOtherState, char symbol) {
            this.linkedStates.put(symbol, nameOtherState);
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