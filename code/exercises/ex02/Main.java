package exercises.ex02;

import classes.Automaton;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Automaton automaton = new Automaton("01");
        automaton.addState("q0", false, true)
                .linkTo('1', "q4")
                .linkTo('0', "q1");
        automaton.addState("q1", false, false)
                .linkTo('1', "q2")
                .linkTo('0', "q0");
        automaton.addState("q2", false, false)
                .linkTo('1', "q4")
                .linkTo('0', "q3");
        automaton.addState("q3", true, false)
                .linkTo('1', "q3")
                .linkTo('0', "q3");
        automaton.addState("q4", false, false)
                .linkTo('1', "q0")
                .linkTo('0', "q5");
        automaton.addState("q5", false, false)
                .linkTo('1', "q3")
                .linkTo('0', "q1");
        String chain = JOptionPane.showInputDialog("Chain");
        System.out.println("Is valid chain? " + automaton.isValidChain(chain));
        System.out.println(automaton.evaluate(chain));
    }
}
