package calculator.domain.calculator;

import java.util.List;

public class Calculator {

    private final Prompt prompt;

    public Calculator() {
        this.prompt = new Prompt();
    }

    public List<Integer> extractInteger(String inputData) {
        List<String> separatedData = prompt.separate(inputData);

        return separatedData.stream()
                .map(data -> {
                    validateNumber(data);
                    return Integer.valueOf(data);
                })
                .toList();
    }

    private void validateNumber(String data) {
        if (data == null || data.isEmpty()) {
            throw new IllegalArgumentException();
        }

        for (char word: data.toCharArray()) {
            if (this.isNotDigit(word)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private boolean isNotDigit(char word) {
        return !Character.isDigit(word);
    }


}
