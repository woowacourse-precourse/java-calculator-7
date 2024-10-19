package calculator.parser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Parser {
    private final HashSet<String> separators = new HashSet<>();
    private final ArrayList<Integer> operands = new ArrayList<>();
    private String input;

    public Parser(List<String> basicSep) {
        separators.addAll(basicSep);
    }

    public ArrayList<Integer> getOperands() {
        return operands;
    }
    public Parser updateInput(String input) {
        this.input = input;
        return this;
    }

    public void addSeparators() {
        for(char c : input.toCharArray()) {
            separators.add(String.valueOf(c));
        }
    }

    public List<Integer> parse(List<Predicate<Integer>> operandPolicies) {
        String exp = String.join("|", separators);
        return Pattern.compile(exp).splitAsStream(input)
                .map(this::parseInteger)
                .map(num -> validatePolicies(num, operandPolicies))
                .collect(Collectors.toList());
    }

    private Integer parseInteger(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid operand: " + s, e);
        }
    }

    private Integer validatePolicies(Integer num, List<Predicate<Integer>> operandPolicies) {
        for (Predicate<Integer> policy : operandPolicies) {
            if (!policy.test(num)) {
                throw new IllegalArgumentException("Illegal policy: " + policy + "\n\tfor: " + num);
            }
        }
        return num;
    }
}
