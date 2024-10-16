package calculator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputString {

    private final String input;
    private Set<Character> customSeparator;
    private final List<Integer> operands;

    public InputString(String input){
        this.input = input;
        this.operands = new ArrayList<>();
        this.customSeparator = new HashSet<>();
        customSeparator.add(',');
        customSeparator.add(':');
    }

    public String getInput() {
        return input;
    }

    public void setSeparator(Character separator) {
        customSeparator.add(separator);
    }

    public Set<Character> getSeparator() {
        return customSeparator;
    }

    public void addOperand(Integer operand) {
        this.operands.add(operand);
    }

    public List<Integer> getOperands() {
        return operands;
    }
}
