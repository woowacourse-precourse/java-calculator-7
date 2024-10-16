package calculator.util;

public class Validator {

    public static boolean isValidate(String input) {

        // 문자열이 빈 경우
        if (input == null) {
            throw new IllegalArgumentException("Input Invalid case1 : input is null");
            // unchecked exception
        }

        // input == ""
        if (input.isEmpty()) {
            return true;
        }

        // 문자열에 숫자가 없는 경우
        if (!input.matches("(?s).*\\d.*")) {
            throw new IllegalArgumentException("Input Innvalid case2");
        }

        // 문자열이 문자로 시작되는 경우
        if (!input.matches("^\\d.*")) {
            System.out.println(input);
            isValidPattern(input);
        }
        

        // 문자열이 문자로 시작되는 경우
        if (input.matches("^\\d.*")) {
            System.out.println("문자열이 숫자로 시작됩니다.");
            System.out.println(input);
        }

        return true;
    }

    private static void isValidPattern(String input) {

        String[] parts = input.split("(?<=\\D)(?=\\d)", 2);

        checkCustomDelimiter(parts[0]);

        String customDelimiters = isValidDelimiter(input).toString();
        String validDelimiter = ",:" + customDelimiters;
        // 숫자 사이에 사용된 구분자가 올바른지 체크
        String[] numbersAndDelimiters = input.split("\\d+");

        // 첫 번째 인덱스는 빈 문자열일 수 있으므로 1부터 시작
        for (int i = 1; i < numbersAndDelimiters.length; i++) {
            String delimiter = numbersAndDelimiters[i];
            // 구분자가 기본 구분자(, :) 또는 커스텀 구분자에 포함되어 있는지 확인
            checkDelimiter(validDelimiter.contains(delimiter));
        }
    }

    private static void checkCustomDelimiter(String customDelimiter) {
        String pattern = "^//(.)\\n.*";

        if (!customDelimiter.matches(pattern)) {
            System.out.println("pattern = " + pattern);
            System.out.println("customDelimiter = " + customDelimiter);
            throw new IllegalArgumentException("Input Invalid case4: 커스텀 구분자 생성 오류");
        }
    }


    private static void checkDelimiter(boolean isContain) {
        if (!isContain) {
            throw new IllegalArgumentException("Input Invalid case4: 잘못된 구분자 사용");
        }
    }

    private static StringBuilder isValidDelimiter(String input) {
        char[] charArray = input.toCharArray();
        StringBuilder delimiterString = new StringBuilder();
        for (int i = 1; i < charArray.length; i++) {
            addDelimiter(charArray, i, delimiterString);
        }

        return delimiterString;
    }

    private static boolean parseDelimiter(char[] input,int index) {
        return input[index - 1] == '/' && input[index + 1] == '\\';
    }

    private static void addDelimiter(char[] input,int index,StringBuilder delimiterString) {
        if (parseDelimiter(input,index)) {
            delimiterString.append(input[index]);
        }
    }
}
