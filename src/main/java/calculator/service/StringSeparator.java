package calculator.service;

import calculator.domain.Calculator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSeparator {

    private Calculator calculator;

    public StringSeparator(Calculator calculator) {
        this.calculator = calculator;
    }

    public void divideSeparator(String str) {
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
        parseAndCalculate(numbersPart, customSeparator);
    }

    private void parseAndCalculate(String numbersPart, String customSeparator) {
        String separators = ",|:";

        if (customSeparator != null) {
            separators += "|" + Pattern.quote(customSeparator);
        }

        String[] tokens = numbersPart.split(separators);

        for (String token : tokens) {
            if (!token.isEmpty()) {
                try {
                    int number = Integer.parseInt(token);
                    calculator.addNumber(number);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
                }
            }
        }
    }
}
