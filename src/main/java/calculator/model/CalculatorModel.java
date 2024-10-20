package calculator.model;

import java.util.*;


public class CalculatorModel {
    private List<Integer> numbers = new ArrayList<>();
    private List<String> dividers = new ArrayList<>();

    public CalculatorModel() {
        dividers.add(",");
        dividers.add(":");
    }

    public void addDivider(String divider) {
        dividers.add(divider);
    }

    public void addNumber(int number) {
        numbers.add(number);
    }

    public int sum() {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }

    // - 예외 처리
    // 예외를 다양하게 처리하면 좋을듯
    // enum으로 처리하는 방법 생각해보자
    // 문자가 들어오거나, 올바르지 않은 구분자 등
    public static void validateNumber(String number ){
        if (number.matches(".*[^1-9].*")) {
            throw new IllegalArgumentException("입력이 올바르지 않음.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public List<String> getDividers() {
        System.out.println(dividers.toString());
        return dividers;
    }
}
