package dfa.exercises.ex02;

import dfa.class_.Automaton;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Automaton automaton = new Automaton("01");
        automaton.addState("q0", false, true)
                .linkTo("q4", '1')
                .linkTo("q1", '0');
        automaton.addState("q1", false, false)
                .linkTo("q2", '1')
                .linkTo("q0", '0');
        automaton.addState("q2", false, false)
                .linkTo("q4", '1')
                .linkTo("q3", '0');
        automaton.addState("q3", true, false)
                .linkTo("q3", '1')
                .linkTo("q3", '0');
        automaton.addState("q4", false, false)
                .linkTo("q0", '1')
                .linkTo("q5", '0');
        automaton.addState("q5", false, false)
                .linkTo("q3", '1')
                .linkTo("q1", '0');
        String chain = JOptionPane.showInputDialog("Chain");
        System.out.println("Is valid chain? " + automaton.isValidChain(chain));
        System.out.println(automaton.evaluate(chain));
    }
}
