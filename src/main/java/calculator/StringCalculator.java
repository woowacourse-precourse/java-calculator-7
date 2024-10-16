package calculator;

public class StringCalculator {
    public int calculate(String input) {
        Character customDelimiter = null;

        if (input.startsWith("//") && input.contains("\\n")) { //커스텀 구분자 존재 시
            String customDelimiterStr = input.substring(2, input.lastIndexOf("\\n"));

            if (customDelimiterStr.length() != 1) { //커스텀 구분자의 길이가 1인지 확인
                throw new IllegalArgumentException();
            }

            customDelimiter = customDelimiterStr.charAt(0);
        }

        String calculateStr = input;
        if (customDelimiter != null) {
            calculateStr = input.substring(input.lastIndexOf("\\n") + 2);
        }

        return 0; //TODO
    }
}
