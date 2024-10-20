package calculator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CalculatorModel {
    private static final String FIRST_DEL = "//";
    private static final int FIRST_START = 0;
    private static final int FIRST_END = 2;
    private static final String SECOND_DEL = "\\n";
    private static final int SECOND_START = 3;
    private static final int SECOND_END = 5;
    private String delimiter = ",:";
    private String clientNumInput = "";

    private void extraDelimiter() {
        if (!Objects.equals(clientNumInput.substring(FIRST_START, FIRST_END), FIRST_DEL)) {
            return;
        }
        if (!Objects.equals(clientNumInput.substring(SECOND_START, SECOND_END), SECOND_DEL)) {
            throw new IllegalArgumentException("구분자가 잘못되었습니다.");
        }
        delimiter += clientNumInput.substring(FIRST_DEL.length(), FIRST_DEL.length() + 1);
        clientNumInput = clientNumInput.substring(SECOND_END);
    }

    public List<Integer> parser(String input) {
        clientNumInput = input;
        extraDelimiter();
        String[] parsedInput = clientNumInput.split("[" + delimiter + ']');
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
