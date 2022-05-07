package nfa;

import javax.swing.JOptionPane;
import java.util.Arrays;

public class FirstWay {
    static int[] acceptanceStates = {2};
    static int initialState = 0;
    static int[][][] transitions = {{{0, 1}, {0}}, {null, {2}}, {null, null}};

    public static void main(String... args) {
        boolean validChain = validateUsingBacktrack(JOptionPane.showInputDialog("Enter the sequence"));
        if (validChain) {
            JOptionPane.showMessageDialog(null, "Chain accepted!");
        } else {
            JOptionPane.showMessageDialog(null, "Chain not accepted!");
        }
    }

    private static boolean validateUsingBacktrack(String chain) {
        int currentSymb;
        int[] currentStates = {initialState};
        int[] newStates;
        StringBuilder newStatesStr = new StringBuilder();
        for (int i = 0; i < chain.length(); i++) {
            currentSymb = Integer.parseInt(Character.toString(chain.charAt(i)));
            for (int currentState : currentStates) {
                newStates = transitions[currentState][currentSymb];
                if (newStates == null || newStates.length == 0) {
                    if (currentStates.length == 1) {
                        return false; //There is no mapping and other state still alive...
                    }
                    continue;
                }
                for (int j : newStates) {
                    newStatesStr.append(j);
                }
            }
            currentStates = new int[newStatesStr.length()];
            for (int k = 0; k < newStatesStr.length(); k++) {
                currentStates[k] = Integer.parseInt(newStatesStr.substring(k, k + 1));
            }
            System.out.println(currentSymb + " -> " + Arrays.toString(currentStates));
            newStatesStr = new StringBuilder();
        }
        for (int currentState : currentStates) {
            for (int acceptanceState : acceptanceStates) {
                if (currentState == acceptanceState) {
                    return true;
                }
            }
        }
        return false;
    }
}
