package calculator.service;

import calculator.command.Command;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorService {

    private static final List<String> DEFAULT_DELIMITERS = List.of(",", ":");
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.*?)\\\\n");

    private Command calculator;

    public void setCommand(Command calculator) {
        this.calculator = calculator;
    }

    public int calculate(final String input) {
        if (isEmpty(input)) {
            return 0;
        }

        String[] numbers = split(input);
        return calculator.execute(numbers);
    }

    private boolean isEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    private String[] split(String input) {
        List<String> delimiters = new ArrayList<>(DEFAULT_DELIMITERS);
        input = extractCustomDelimiter(input, delimiters);
        String delimiterRegex = String.join("|", delimiters);
        return input.split(delimiterRegex);
    }

    /*
    parameter : `input` - 사용자 입력
                `delimiters` - 커스텀 구분자를 저장할 리스트
    return : `input` - 앞 부분의 커스텀 구분자 정의를 제외한 사용자 입력
     */
    private String extractCustomDelimiter(String input, List<String> delimiters) {
        if (!input.startsWith("//")) {
            return input;
        }

        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        int startNumberIndex = 0;

        while (matcher.find()) {
            String delimiter = matcher.group(1);
            delimiters.add(Pattern.quote(delimiter));
            startNumberIndex = matcher.end();
        }

        return input.substring(startNumberIndex);
    }
}
