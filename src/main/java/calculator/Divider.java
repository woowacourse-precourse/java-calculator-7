package calculator;

import java.util.*;

public class Divider {
    List<Character> divider;
    List<Character> problemMatcher;
    boolean slashstarted;
    boolean append;

    public Divider() {
        divider = new ArrayList<Character>();
        divider.add(',');
        divider.add(':');
        problemMatcher = new ArrayList<Character>();

        slashstarted = false;
        append = false;
    }

    public void judge(Character c) {
        if(divider.contains(c)) {
            return;
        }
        else if(c.equals('/') && !slashstarted) {
            slashstarted = true;
        }
        else if(c.equals('/') && slashstarted) {
            append = true;
        }
        else if(c.equals('n') && slashstarted) {
            slashstarted = false;
            append = false;
        }
        else if(append) {
            if(problemMatcher.contains(c)) {
                problemMatcher.remove(c);
            }
            divider.add(c);
        }
        else {
            problemMatcher.add(c);
        }
    }

    public List<Character> getProblemMatcher() {
        return problemMatcher;
    }
}
