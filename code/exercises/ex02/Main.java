package exercises.ex02;

import classes.Automaton;
import classes.State;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        State q0 = new State("q0", false, true);
        State q1 = new State("q1", false, false);
        State q2 = new State("q2", false, false);
        State q3 = new State("q3", true, false);
        State q4 = new State("q4", false, false);
        State q5 = new State("q5", false, false);
        q0.setLinkedState('1', q4);
        q0.setLinkedState('0', q1);
        q1.setLinkedState('1', q2);
        q1.setLinkedState('0', q0);
        q2.setLinkedState('1', q4);
        q2.setLinkedState('0', q3);
        q3.setLinkedState('1', q3);
        q3.setLinkedState('0', q3);
        q4.setLinkedState('1', q0);
        q4.setLinkedState('0', q5);
        q5.setLinkedState('1', q3);
        q5.setLinkedState('0', q1);
        Automaton automaton = new Automaton(q0, q1, q2, q3, q4, q5);
        String chain = JOptionPane.showInputDialog("Chain");
        System.out.println("Is valid chain? " + automaton.isValidChain(chain));
        System.out.println(automaton.evaluate(chain));
    }
}
