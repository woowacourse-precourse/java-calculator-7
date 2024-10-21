package calculator.Utils;

public class StringUtils {
    public static String[] splitInput(String input, String regex) {
        return input.split(regex);
    }

    // 커스텀 구분자를 추출하는 메서드
    public static String extractCustomDelimiter(String input) {
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");
            return input.substring(2, delimiterEndIndex); // 커스텀 구분자 추출
        }
        return "[,|:]"; // 기본 구분자 반환
    }

    // 커스텀 구분자를 제거한 숫자 부분 추출
    public static String extractNumbersPart(String input) {
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");
            return input.substring(delimiterEndIndex + 2); // 구분자 부분을 제거하고 숫자 부분 반환
        }
        return input;
    }

    // 커스텀 구분자 외의 문자가 포함되어 있는지 확인하는 메서드
    public static boolean containsInvalidDelimiter(String input, String delimiter) {
        for (char c : input.toCharArray()) {
            // 커스텀 구분자와 숫자가 아닌 다른 문자가 있는지 확인
            if (!Character.isDigit(c) && !String.valueOf(c).equals(delimiter)) {
                return true; // 허용되지 않은 문자가 존재
            }
        }
        return false;
    }
}
