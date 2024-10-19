package calculator;

import camp.nextstep.edu.missionutils.Console;

public class StringCalculator {
    private final StringBuilder separators;
    private String input;

    public StringCalculator() {
        this.separators = new StringBuilder();
        this.input = "";
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
    
    public void run() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        input = Console.readLine().trim();

        if (input.startsWith("//") && input.contains("\\n")) {
            splitCustomSeparator();
        }

        Console.close();
    }
}
