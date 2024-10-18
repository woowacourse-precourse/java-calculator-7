package calculator.model;

import java.util.ArrayList;

public class Operators {
    private final ArrayList<Character> operatorList;

    public Operators(ArrayList<Character> initialOperators) {
        operatorList = initialOperators;
    }

    public void addOperators(char operator) {
        operatorList.add(operator);
    }

    public boolean contains(char ch) {
        return operatorList.contains(ch);
    }
}
