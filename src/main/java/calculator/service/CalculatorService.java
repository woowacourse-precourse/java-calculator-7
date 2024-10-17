package calculator.service;

import calculator.view.Input;
import calculator.view.Output;
import java.util.Arrays;
import java.util.Optional;

public class CalculatorService {

    private final char[] constantDelimiter = {',', ':'};
    private Optional<char[]> customDelimiter;
    private Optional<String> input;
    private String formatInput;
    private Optional<int[]> numbersToCalculate;

    public void input() {
        Output.inputMessage();
        input = Input.input();
    }

    public void findCustomDelimiter() {
        String userInput = input.orElseThrow(() -> new IllegalArgumentException("입력값이 없습니다"));
        if (userInput.startsWith("//") && userInput.contains("\\n")) {
            customDelimiter = Optional.of(userInput.substring(2, userInput.indexOf("\\n")).toCharArray());
            char[] customDelimiterChars = customDelimiter.orElse(new char[0]);
            for (char c : customDelimiterChars) {
                if (c >= '0' && c <= '9') {
                    throw new IllegalArgumentException("커스텀 구분자에 숫자는 등록할 수 없습니다");
                }
                if (c == '\\' || c == '/') {
                    throw new IllegalArgumentException("'/'와'\\'는 커스텀 구분자를 등록하는 데에만 사용할 수 있습니다");
                }
            }
            formatInput = userInput.substring(userInput.indexOf("\\n") + 2);
        }

        formatInput = Optional.ofNullable(formatInput).orElse(userInput);
        if (formatInput.contains("/") || formatInput.contains("\\")) {
            throw new IllegalArgumentException("'/'와'\\'는 커스텀 구분자를 등록하는 데에만 사용할 수 있습니다");
        }

        customDelimiter = Optional.ofNullable(customDelimiter).orElse(Optional.empty());
    }

    public void deleteDelimiter() {
        String removeDelimiters = formatInput.chars().filter(i -> {
                    char currentChar = (char) i;

                    boolean isDelimiter = false;
                    for (char c : constantDelimiter) {
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
                }).mapToObj(c -> (char) c)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();

        isNumeric(removeDelimiters);
    }

    private void isNumeric(String removeDelimiters) {
        numbersToCalculate = Optional.of(removeDelimiters.chars().filter(i -> {
            if (i < '0' || i > '9') {
                throw new IllegalArgumentException("구분자나 숫자가 아닌 문자가 발견되었습니다: " + (char) i);
            }
            return true;
        }).map(i -> i - '0').toArray());
    }

    public void output() {
        int[] numbers = numbersToCalculate.orElse(new int[]{});
        int result = Arrays.stream(numbers).sum();
        Output.outputMessage();
        Output.result(result);
    }
}
