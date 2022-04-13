package exercises.ex01;

import classes.Automaton;
import classes.State;

public class Main {
    public static void main(String[] args) {
        State state1 = new State("state 1 (initial)", false, true);
        State state2 = new State("state 2 (acceptance)", true, false);
        state1.setLinkedState('0', state1);
        state1.setLinkedState('1', state2);
        state2.setLinkedState('0', state2);
        state2.setLinkedState('1', state1);
        Automaton automaton = new Automaton(state1, state2);
        String chain = "0000100100001";
        System.out.println("Valid chain? " + automaton.isValidChain(chain));
        System.out.println(automaton.evaluate(chain));
    }
}
