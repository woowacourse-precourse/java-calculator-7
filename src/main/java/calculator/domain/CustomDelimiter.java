package calculator.domain;

public class CustomDelimiter {

    public void registerCustomDelimiter(String input, Delimiter delimiter) {
        if (!input.contains("\\n")) {
            throw new IllegalArgumentException("커스텀 구분자 설정 형식이 잘못되었습니다. '\\n'이 없습니다.");
        }

        int newLineIndex = input.indexOf("\\n");

        String customDelimiterPart = input.substring(2, newLineIndex);

        if (customDelimiterPart.length() != 1 || Character.isDigit(customDelimiterPart.charAt(0))) {
            throw new IllegalArgumentException("커스텀 구분자는 1자리 문자여야 하며 숫자가 될 수 없습니다.");
        }

        char customDelimiter = customDelimiterPart.charAt(0);
        delimiter.addCustomDelimiter(customDelimiter);
    }

}
