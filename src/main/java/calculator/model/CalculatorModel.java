package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class CalculatorModel {
    private String delimiter = ",:";

    public List<Integer> parser(String input) throws IllegalArgumentException {
        int startIdx = input.indexOf("//");
        int endIdx = input.indexOf("\\n");
        if (startIdx != -1 && endIdx != -1) {
            delimiter += input.substring(startIdx + 2, endIdx);
            input = input.substring(endIdx + 2);
        }

        String[] parsedInput = input.split("[" + delimiter + ']');
        List<Integer> result = new ArrayList<>();

        for (String s : parsedInput) {
            int num = Integer.parseInt(s);
            if (num < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
            result.add(Integer.parseInt(s));
        }
        return result;
    }

    public int add(List<Integer> operands) {
        return operands.stream().mapToInt(Integer::intValue).sum();
    }
}
