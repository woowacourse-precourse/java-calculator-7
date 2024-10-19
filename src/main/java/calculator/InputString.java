package calculator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputString {

    private final String input;
    private Set<Character> customSeparators;
    private List<Integer> operands;

    public InputString(String input){
        this.input = input;
        this.customSeparators = new HashSet<>();
        customSeparators.add(',');
        customSeparators.add(':');

        setCustomSeparator();
        setOperands();
    }

    public String getInput() {
        return input;
    }

    public Set<Character> getSeparator() {
        return customSeparators;
    }

    public List<Integer> getOperands() {
        return operands;
    }

    private void setCustomSeparator(){
        InputParser inputParser = new InputParser();
        Character customSeparator = inputParser.getCustomParser(input);
        customSeparators.add(customSeparator);
    }

    private void setOperands(){
        InputParser inputParser = new InputParser();
        operands = inputParser.getIntegerList(input, customSeparators);
    }
}
