package calculator;

import java.util.StringTokenizer;

public class Validator {
    public String customDelimiterBeingCheck(String input) {

        if (input.length() > 4) {
            String customDelimiter = input.substring(0, 5);
            boolean being = customDelimiter.matches("^//\\S\\\\n$");
            if (being) return String.valueOf(input.charAt(2));
        }
        return "";
    }

    public StringTokenizer inputValidCheck(String input) {

        String delimiters = ",:" + customDelimiterBeingCheck(input);
        if (delimiters.length() == 3) input = input.substring(5);
        StringTokenizer st = new StringTokenizer(input, delimiters);

        while (st.hasMoreTokens()) {
            String s = st.nextToken();
            try {
                long num = Long.parseLong(s);
                if (num < 0) {
                    throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        }
        return new StringTokenizer(input, delimiters);
    }
}
