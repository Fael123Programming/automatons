package exercises.ex01;

import classes.Automaton;

public class Main {
    public static void main(String[] args) {
        Automaton automaton = new Automaton("01");
        automaton.addState("q0", false, true)
                .linkTo('0', "q0")
                .linkTo('1', "q1");
        automaton.addState("q1", true, false)
                .linkTo('0', "q1")
                .linkTo('1', "q0");
        String chain = "0000100100001";
        System.out.println("Valid chain? " + automaton.isValidChain(chain));
        System.out.println(automaton.evaluate(chain));
    }
}
