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
            throw new IllegalArgumentException("Input Invalid case2");
        }

        // 문자열이 문자로 시작되는 경우
        if (input.matches("^\\D.*")) {
            if(input.matches("(//.+\\n)+(\\d+([,:a-zA-Z])*\\d*)+")) {
                return true;
            } else {
                throw new IllegalArgumentException("Input Invalid case3");
            }
        }

        // 문자열이 숫자로 시작되는 경우
//        if
        return true;
    }

    private static void isValidPattern(String input) {
        String pattern = "(//.+\\n)+(\\d+([,:a-zA-Z])*\\d*)+";

        if(input.matches(pattern)) {
            isValidDelimiter(input);
        }
    }

    private static void isValidDelimiter(String input) {
        char[] charArray = input.toCharArray();
        char[] delimiter = new char[0];
        for (int i = 0; i < charArray.length; i++) {
            if (parseDelimiter(charArray,i)) {
                delimiter.append(charArray[i]);
            }
        }
    }

    private static boolean parseDelimiter(char[] input,int index) {
        return input[index - 1] == '/' && input[index + 1] == '\\';
    }
}
