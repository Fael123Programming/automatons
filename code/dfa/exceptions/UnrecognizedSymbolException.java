package dfa.exceptions;

public class UnrecognizedSymbolException extends RuntimeException {
    public UnrecognizedSymbolException(char symbol) {
        super("unrecognized symbol '" + symbol + "'");
    }
}
