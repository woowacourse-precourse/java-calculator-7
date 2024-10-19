package calculator;

public class Parser {
    public static void checkDelimiter(String input) {
        checkDelimiterType(input.charAt(0));
        if (Calculator.getIsCustomDelimiter() == true) {
            extractCustomDelimiter(input);
        }
        else {
            if (Validator.isValidDefaultDelimiterString(input) == false)
                throw new IllegalArgumentException("Format is invalid.");
        }
    }

    public static void checkDelimiterType(char firstChar) {
        boolean value = !(Character.isDigit(firstChar));
        Calculator.setIsCustomDelimiter(value);
    }

    public static void extractCustomDelimiter(String input) {
        // 유효성 검사 통과하면 구분자 추출하고
        // calculator에 set함수 만들어서 설정하기
    }
}
