package calculator.service;

import static calculator.constant.CharacterConstants.CONSTANT_DELIMITER;
import static calculator.constant.CharacterConstants.CUSTOM_DELIMITER_ENDS_WITH;
import static calculator.constant.CharacterConstants.CUSTOM_DELIMITER_STARTS_WITH;
import static calculator.constant.CharacterConstants.INVALID_CUSTOM_DELIMITER_END;
import static calculator.constant.CharacterConstants.INVALID_CUSTOM_DELIMITER_START;
import static calculator.constant.ErrorMessages.EMPTY_INPUT_MESSAGE;
import static calculator.constant.ErrorMessages.INVAILD_CHAR_MESSAGE;
import static calculator.constant.ErrorMessages.INVALID_DELIMITER_MESSAGE;
import static calculator.constant.ErrorMessages.NUMBER_ASSIGN_ERROR_MESSAGE;

import calculator.view.Input;
import calculator.view.Output;
import java.util.Arrays;
import java.util.Optional;

public class CalculatorService {

    private Optional<char[]> customDelimiter;
    private Optional<String> input;
    private String formatInput;
    private Optional<int[]> numbersToCalculate;

    public void input() {
        Output.firstMessage();
        input = Input.input();
    }

    public void findCustomDelimiter() {
        String userInput = input.orElseThrow(() -> new IllegalArgumentException(EMPTY_INPUT_MESSAGE));
        if (userInput.startsWith(CUSTOM_DELIMITER_STARTS_WITH) && userInput.contains(CUSTOM_DELIMITER_ENDS_WITH)) {
            int delimiterEndIndex = userInput.indexOf(CUSTOM_DELIMITER_ENDS_WITH);
            customDelimiter = Optional.of(userInput.substring(2, delimiterEndIndex).toCharArray());
            char[] customDelimiterChars = customDelimiter.orElse(new char[0]);
            validCustomDelimiter(customDelimiterChars);
            formatInput = userInput.substring(delimiterEndIndex + 2);
        }

        formatInput = Optional.ofNullable(formatInput).orElse(userInput);
        validFormatInput(formatInput);

        customDelimiter = Optional.ofNullable(customDelimiter).orElse(Optional.empty());
    }

    private void validFormatInput(String formatInput) {
        if (formatInput.contains(INVALID_CUSTOM_DELIMITER_START) || formatInput.contains(
                INVALID_CUSTOM_DELIMITER_END)) {
            throw new IllegalArgumentException(INVAILD_CHAR_MESSAGE);
        }
    }

    private void validCustomDelimiter(char[] customDelimiterChars) {
        for (char c : customDelimiterChars) {
            if (Character.isDigit(c)) {
                throw new IllegalArgumentException(NUMBER_ASSIGN_ERROR_MESSAGE);
            }
            if (String.valueOf(c).equals(INVALID_CUSTOM_DELIMITER_START)
                    || String.valueOf(c).equals(INVALID_CUSTOM_DELIMITER_END)) {
                throw new IllegalArgumentException(INVAILD_CHAR_MESSAGE);
            }
        }
    }

    public void deleteDelimiter() {
        String removeDelimiters = formatInput.chars()
                .filter(i -> isDelimiter((char) i))
                .mapToObj(c -> (char) c)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();

        isNumeric(removeDelimiters);
    }

    private boolean isDelimiter(char currentChar) {
        boolean isDelimiter = false;
        for (char c : CONSTANT_DELIMITER) {
            if (currentChar == c) {
                isDelimiter = true;
                break;
            }
        }
        for (char c : customDelimiter.orElse(new char[0])) {
            if (currentChar == c) {
                isDelimiter = true;
                break;
            }
        }
        return !isDelimiter;
    }

    private void isNumeric(String removeDelimiters) {
        numbersToCalculate = Optional.of(removeDelimiters.chars().filter(i -> {
            if (!Character.isDigit(i)) {
                throw new IllegalArgumentException(INVALID_DELIMITER_MESSAGE + (char) i);
            }
            return true;
        }).map(i -> i - '0').toArray());
    }

    public void output() {
        int[] numbers = numbersToCalculate.orElse(new int[]{});
        int result = Arrays.stream(numbers).sum();
        Output.resultMessage();
        Output.result(result);
    }
}
