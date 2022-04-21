package dfa.exceptions;
public class InitialStateNotFoundException extends RuntimeException {
    public InitialStateNotFoundException() {
        super("initial state was not found");
    }
}
