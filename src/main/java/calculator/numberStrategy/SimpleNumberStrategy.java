package calculator.numberStrategy;

import java.util.ArrayList;
import java.util.List;

public class SimpleNumberStrategy implements NumberStrategy {
    public SimpleNumberStrategy() {
    }

    @Override
    public List<Integer> extractNumber(String userInput, List<String> delimiter) throws IllegalArgumentException {
        String regex = String.join("|", delimiter);
        String[] splitResults = userInput.split(regex, -1);
        if (!isCorrectlySplit(splitResults)) {
            throw new IllegalArgumentException("구분자는 2개의 문자열을 분리해야 한다");
        }
        return parseInt(splitResults);
    }

    private boolean isCorrectlySplit(String[] splitResults) {
        for (String splitResult : splitResults) {
            if (splitResult.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> parseInt(String[] splitResults) throws IllegalArgumentException {
        List<Integer> operands = new ArrayList<>();
        for (String splitResult : splitResults) {
            if (splitResult.matches(".*\\D.*")) {
                throw new IllegalArgumentException("양수 이외에 다른 문자가 들어왔다");
            }
            try {
                Integer operand = Integer.parseInt(splitResult);
                operands.add(operand);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("피연산자가 Integer 범위를 넘어간다");
            }
        }
        return operands;
    }
}
