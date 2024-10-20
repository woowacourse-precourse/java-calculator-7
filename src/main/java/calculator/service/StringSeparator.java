package calculator.service;

import calculator.domain.Calculator;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSeparator {

    private Calculator calculator;

    public StringSeparator(Calculator calculator) {
        this.calculator = calculator;
    }

    public void extractAndProcessSeparators(String str) {
        String customSeparator = null;
        String numbersPart = str;

        if (str.startsWith("//")) {
            Pattern customPattern = Pattern.compile("//(.*?)\\\\n(.*)");
            Matcher matcher = customPattern.matcher(str);

            if (matcher.matches()) {
                customSeparator = matcher.group(1);
                numbersPart = matcher.group(2);
                calculator.addSeparator(customSeparator);
            } else {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        }
        parseAndCalculate(numbersPart);
    }

    private void parseAndCalculate(String numbersPart) {
        List<String> escapedSeparators = new ArrayList<>();
        for (String sep : calculator.getSeparators()) {
            escapedSeparators.add(Pattern.quote(sep));
        }

        String separators = String.join("|", escapedSeparators);
        String[] tokens = numbersPart.split(separators);

        for (String token : tokens) {
            if (!token.isEmpty()) {
                try {
                    int number = Integer.parseInt(token);
                    calculator.addNumber(number);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("잘못된 입력입니다.");
                }
            }
        }
    }
}
