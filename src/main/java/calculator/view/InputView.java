package calculator.view;

import static calculator.util.SeparatorProcessor.getNumbers;
import static calculator.util.SeparatorProcessor.getSeparators;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InputView {

    public List<Integer> getAdditionNumbers() {
        String input = Console.readLine();

        if (input.isBlank()) {
            return Collections.emptyList();
        }

        String separators = getSeparators(input);
        String numbers = getNumbers(input);

        return splitAndParseNumbers(separators, numbers);
    }

    private List<Integer> splitAndParseNumbers(String separators, String numbers) {
        String[] inputTokens = numbers.split(separators);

        return Arrays.stream(inputTokens)
                .map(this::parseNumber)
                .toList();
    }

    private int parseNumber(String token) {
        try {
            int number = Integer.parseInt(token);
            validatePositiveNumber(number);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

    private void validatePositiveNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("양수만 입력할 수 있습니다.");
        }
    }
}
