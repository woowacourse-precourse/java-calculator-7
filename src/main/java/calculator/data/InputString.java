package calculator.data;

import calculator.service.InputParser;
import calculator.service.Parser;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static calculator.validation.CheckForm.checkFormOfCustomSeparator;
import static calculator.validation.CheckForm.checkFormOfOperands;

public class InputString {

    private final String input;
    private Set<Character> customSeparators;
    private List<Integer> operands;

    private Parser parser;

    public InputString(String input){
        this.input = input;
        this.customSeparators = new HashSet<>();
        this.parser = new InputParser();

        customSeparators.add(',');
        customSeparators.add(':');

        checkFormOfCustomSeparator(input);
        setCustomSeparator();

        checkFormOfOperands(input, customSeparators);
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
        Character customSeparator = parser.getCustomParser(input);
        customSeparators.add(customSeparator);
    }

    private void setOperands(){
        operands = parser.getIntegerList(input, customSeparators);
    }
}
