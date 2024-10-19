package calculator;

public class InputValidator {


    public static void validateCustomDelimiter(String input, int start, int end) {

        if (!input.startsWith("//")  || !input.contains("\\n"))  {
            throw new IllegalArgumentException("구분자 정의가 올바르지 않습니다.");
        }

        if (end == -1) {
            throw new IllegalArgumentException("구분자 정의가 올바르지 않습니다.");
        }

        if (start == end) {
            throw new IllegalArgumentException("구분자 정의에 커스텀 구분자가 없습니다.");
        }
    }

    public static void validate(String delimiters, String numbersSection) {

        if (numbersSection.matches(".*[" + delimiters + "]{" + 2 + ",}.*")) {
            throw new IllegalArgumentException("연속된 구분자는 허용되지 않습니다.");
        }

        String regex = "[" + delimiters + "]";
        String[] parts = numbersSection.split(regex);
        for (String part : parts) {
            if (!part.isEmpty() && !part.matches("\\d+")) {
                throw new IllegalArgumentException("사용할 수 없는 구분자가 포함되어 있습니다");
            }
        }

        if (numbersSection.length() > 0 && delimiters.contains(String.valueOf(numbersSection.charAt(0)))) {
            throw new IllegalArgumentException("입력은 구분자로 시작할 수 없습니다.");
        }
    }
}
