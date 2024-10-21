package calculator.domain;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputInfo {

    private String input;
    private final StringBuilder separators;
    private final List<BigInteger> numbers;

    public InputInfo(String input) {
        this.input = input;
        this.separators = new StringBuilder();
        this.numbers = new ArrayList<>();
        separators.append(",:");
        inputParse();
    }

    private void inputParse() {
        if (input.startsWith("//") && input.contains("\\n")) {
            splitCustomSeparator();
        }
        if (!input.isEmpty()) {
            splitNumbers();
        }
    }

    private void splitCustomSeparator() {
        int dividerIndex = input.lastIndexOf("\\n");
        String customSeparator = input.substring(2, dividerIndex);
        input = input.substring(dividerIndex + 2);

        if (customSeparator.isEmpty()) {
            return;
        }
        if (isMoreThanOneCustomSeparator(customSeparator)) {
            throw new IllegalArgumentException("커스텀 구분자는 하나만 지정할 수 있습니다.");
        }
        if (isDigitCustomSeparator(customSeparator)) {
            throw new IllegalArgumentException("커스텀 구분자는 숫자가 될 수 없습니다.");
        }

        addCustomSeparator(customSeparator);
    }

    private boolean isMoreThanOneCustomSeparator(String customSeparator) {
        return customSeparator.length() > 1;
    }

    private boolean isDigitCustomSeparator(String customSeparator) {
        return isDigit(customSeparator.charAt(0));
    }

    private boolean isDigit(char c) {
        return c - 48 >= 0 && c - 48 <= 9;
    }

    private void addCustomSeparator(String customSeparator) {
        if (!separators.toString().contains(customSeparator)) {
            separators.append(customSeparator);
        }
    }

    private void splitNumbers() {
        StringTokenizer st = new StringTokenizer(input, separators.toString());
        while (st.hasMoreTokens()) {
            try {
                BigInteger num = new BigInteger(st.nextToken());
                if (num.compareTo(BigInteger.ZERO) < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않습니다.");
                }
                numbers.add(num);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("구분자로 지정되지 않은 문자가 있습니다.");
            }
        }
    }

    public List<BigInteger> getNumbers() {
        return numbers;
    }
}
