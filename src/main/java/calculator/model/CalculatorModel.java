package calculator.model;

import java.util.*;


public class CalculatorModel {
    private List<Integer> numbers = new ArrayList<>();
    private DividerManager dividerManager = new DividerManager();

    public void addDivider(String divider) {
        dividerManager.addDivider(divider);
    }

    public void addNumber(int number) {
        numbers.add(number);
    }

    public void validateNumber(String input) {
        InputValidator.validateNumber(input);
    }

    public int sum() {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }



    public List<String> getDividers() {
        return dividerManager.getDividers();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }


}
