package dfa.exercises.ex01;

import dfa.class_.Automaton;

public class Main {
    public static void main(String[] args) {
        Automaton automaton = new Automaton("01");
        automaton.addState("q0", false, true)
                .linkTo("q0", '0')
                .linkTo("q1", '1');
        automaton.addState("q1", true, false)
                .linkTo("q1", '0')
                .linkTo("q0", '1');
        String chain = "0000100100001";
        System.out.println("Valid chain? " + automaton.isValidChain(chain));
        System.out.println(automaton.evaluate(chain));
    }
}
