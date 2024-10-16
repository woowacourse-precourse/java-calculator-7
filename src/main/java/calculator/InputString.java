package calculator;

import java.util.ArrayList;
import java.util.List;

public class InputString {

    private final String input;
    private String customSeparator;
    private final List<Integer> operands;

    public InputString(String input){
        this.input = input;
        this.operands = new ArrayList<>();
    }

    public String getInput() {
        return input;
    }

    public void setSeparator(String separator) {
        this.customSeparator = separator;
    }

    public String getSeparator() {
        return customSeparator;
    }

    public void addOperand(Integer operand) {
        this.operands.add(operand);
    }

    public List<Integer> getOperands() {
        return operands;
    }
}
