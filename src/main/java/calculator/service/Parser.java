package calculator.service;

import calculator.config.SeparatorConstants;
import calculator.model.Separator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Parser {

    private final SeparatorService separatorService;

    public Parser(SeparatorService separatorService) {
        this.separatorService = separatorService;
    }

    public List<Integer> parse(String input) {
        if (isEmptyInput(input)) {
            return new ArrayList<>();
        }

        String processedInput = processCustomSeparator(input);
        return extractNumbers(processedInput);
    }

    private boolean isEmptyInput(String input) {
        return input == null || input.isEmpty();
    }

    private String processCustomSeparator(String input) {
        if (input.startsWith(SeparatorConstants.CUSTOM_SEPARATOR_PREFIX)) {
            return separatorService.extractCustomSeparator(input);
        }
        return input;
    }

    private List<Integer> extractNumbers(String part) {
        List<Integer> numbers = new ArrayList<>();
        String[] tokens = part.split(getDelimitersAsString());

        for (String token : tokens) {
            String trimmedToken = token.trim();
            if (!trimmedToken.isEmpty()) {
                numbers.add(convertToNumber(trimmedToken));
            }
        }

        return numbers;
    }

    private String getDelimitersAsString() {
        Set<Separator> separators = separatorService.findAllSeparator();
        return String.join("|", separators.stream()
                .map(separator -> String.valueOf(separator.value()))
                .toArray(String[]::new));
    }

    private Integer convertToNumber(String token) {
        validateNumber(token);
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 숫자 입력: " + token, e);
        }
    }

    private void validateNumber(String token) {
    if (token.charAt(0) == '-') {
        throw new IllegalArgumentException("음수는 허용되지 않습니다: " + token);
    }
}
}
