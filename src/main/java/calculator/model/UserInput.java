package calculator.model;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInput {
    private final String input;

    public UserInput(String input) {
        this.input = input;
    }

    public List<Long> parser() {
        String delimiterRegex = extractDelimiterRegex(input);
        String numbers = extractNumbers(delimiterRegex);

        return convertToLongList(new InputParser(delimiterRegex, numbers).parse());
    }

    private String extractDelimiterRegex(String userInput) {
        return new Delimiter(userInput).getDelimiterRegex();
    }

    private String extractNumbers(String delimiterRegex) {
        String numbers = "";

        if (delimiterRegex.equals(Delimiter.DEFAULT_DELIMITERS)) {
            numbers = input;
        } else {
            String pattern = String.join("", Delimiter.CUSTOM_DELIMITERS_START, "(.)", Delimiter.CUSTOM_DELIMITERS_END,
                    "(.*)");
            Matcher m = Pattern.compile(pattern).matcher(input);
            if (m.find()) {
                numbers = m.group(2);
            }

        }

        return numbers;
    }

    private List<Long> convertToLongList(List<String> userInputNumbers) {
        return userInputNumbers
                .stream()
                .map(token -> {
                    calculator.model.Number number = new Number(token);
                    return number.getInputNumber();
                }).toList();
    }

    public String getInput() {
        return input;
    }

    public boolean isInputEmpty() {
        return input.isEmpty();
    }
}
