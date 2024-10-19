package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StringCalculator {
    private final StringBuilder separators;
    private final List<BigInteger> numbers;
    private String input;
    private BigInteger result;

    public StringCalculator() {
        this.separators = new StringBuilder();
        this.numbers = new ArrayList<>();
        this.input = "";
        this.result = BigInteger.ZERO;
        separators.append(",:");
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

        separators.append(customSeparator);
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

    private BigInteger addNumbers() {
        return numbers.stream().reduce(result, BigInteger::add);
    }

    public void run() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        input = Console.readLine().trim();

        if (input.startsWith("//") && input.contains("\\n")) {
            splitCustomSeparator();
        }

        if (!input.isEmpty()) {
            splitNumbers();
        }

        if (!numbers.isEmpty()) {
            result = addNumbers();
        }

        System.out.println("결과 : " + result);
        Console.close();
    }
}
