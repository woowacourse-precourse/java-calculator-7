package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormulaParsing {
    private final static FormulaParsing instance = new FormulaParsing();
    private final int CUSTOM_SEPARATOR_PATTERN_SIZE = 5;

    private FormulaParsing() {
    }

    public static FormulaParsing getInstance() {
        return instance;
    }

    public String extractCustomSeparator(String calcFormula) {
        int index = getFirstNumberIndex(calcFormula);

        if (index == 0) {
            return "";
        }
        if (index % CUSTOM_SEPARATOR_PATTERN_SIZE != 0) {
            throw new IllegalArgumentException("커스텀 구분자 지정 규칙이 틀렸습니다.");
        }

        StringBuilder customSeparators = getCustomSeparators(calcFormula, index);

        if (customSeparators.length() != (index / CUSTOM_SEPARATOR_PATTERN_SIZE)) {
            throw new IllegalArgumentException("커스텀 구분자 지정 규칙이 틀렸습니다.");
        }

        return customSeparators.toString();
    }

    private int getFirstNumberIndex(String calcFormula) {
        for (int index = 0; index < calcFormula.length(); index++) {
            if (Character.isDigit(calcFormula.charAt(index))) {
                return index;
            }
        }
        return 0;
    }

    private StringBuilder getCustomSeparators(String calcFormula, int endIndex) {
        StringBuilder customSeparators = new StringBuilder();
        String substring = calcFormula.substring(0, endIndex);
        String regex = "/{2}.\\\\n";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(substring);

        while (matcher.find()) {
            customSeparators.append(matcher.group().charAt(2));
        }

        return customSeparators;
    }

    public List<Long> extractNumber(String calcFormula, String customSeparator) {
        String substring = calcFormula.substring(customSeparator.length() * CUSTOM_SEPARATOR_PATTERN_SIZE);
        String[] numbers = substring.split("[" + customSeparator + ":,]");

        try {
            return Arrays.stream(numbers)
                    .map(Long::parseLong)
                    .filter(this::checkNegativeNumber)
                    .toList();
        } catch (NumberFormatException e) {
            checkNumberFormat(e);
            throw new IllegalArgumentException("입력값이 long 범위를 넘어갔습니다.");
        }
    }

    private boolean checkNegativeNumber(long number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 입력으로 들어오지 못합니다.");
        }
        return true;
    }

    private void checkNumberFormat(NumberFormatException e) {
        String message = e.getMessage();
        String errorInput = message.substring(message.indexOf(':') + 3, message.length() - 1);

        for (int i = 0; i < errorInput.length(); i++) {
            if (!Character.isDigit(errorInput.charAt(i))) {
                throw new IllegalArgumentException("구분자 이외의 문자가 수식에 포함되있습니다.");
            }
        }
    }
}
