package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class CalculatorModel {
    private String delimiter = ",:";

    private String extraDelimiter(String input) {
        int startIdx = input.indexOf("//");
        int endIdx = input.indexOf("\\n");
        if (startIdx != -1 && endIdx != -1) {
            delimiter += input.substring(startIdx + 2, endIdx);
            input = input.substring(endIdx + 2);
        }else if(startIdx != -1 || endIdx != -1){
            throw new IllegalArgumentException("구분자를 분리할 수 없습니다.");
        }
        return input;
    }

    public List<Integer> parser(String input) {
        input = extraDelimiter(input);
        String[] parsedInput = input.split("[" + delimiter + ']');
        List<Integer> result = new ArrayList<>();

        for (String s : parsedInput) {
            int num = Integer.parseInt(s);
            if (num < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
            result.add(num);
        }
        return result;
    }

    public int add(List<Integer> operands) {
        return operands.stream().mapToInt(Integer::intValue).sum();
    }
}
