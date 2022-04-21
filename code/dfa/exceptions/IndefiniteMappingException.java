package dfa.exceptions;

public class IndefiniteMappingException extends RuntimeException {
    public IndefiniteMappingException(char symbol, String stateName) {
        super("There is no mapping for the symbol '" + symbol + "' set from the state '" + stateName);
    }
}
