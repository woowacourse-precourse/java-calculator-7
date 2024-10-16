package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {

    private List<Character> identifiers;
    private List<Long> operands;

    // TODO List에 기본 값을 그냥 넣을 것인가?
    public Calculator() {
        this.identifiers = new ArrayList<>(Arrays.asList('.', ':'));
    }

    public void addIdenfitier(char identifier) {
        identifiers.add(identifier);
    }

    public void addOperands(List<Long> parsedOperands) {
        operands = parsedOperands;
    }

    public List<Long> getOperands() {
        return operands;
    }

    public List<Character> getIdentifiers() {
        return identifiers;
    }

    public String identifiersToString() {
        return identifiers.toString();
    }
}
