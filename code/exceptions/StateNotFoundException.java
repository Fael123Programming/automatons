package exceptions;

public class StateNotFoundException extends RuntimeException {
    public StateNotFoundException(String stateName) {
        super("state with name '" + stateName + "' was not found");
    }
}
