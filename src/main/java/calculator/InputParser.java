package calculator;

public class InputParser {

    public String getCustomSeparator(String input) {
        if (input.startsWith("//") && input.length() > 3 && input.substring(3, 5).equals("\\n")) {
            return Character.toString(input.charAt(2));
        } else {
            return null;
        }
    }

    public String[] splitString(String input) {
        String separator = getCustomSeparator(input);
        if (separator != null) {
            input = input.substring(5); // 커스텀 구분자가 있으면 "//;\n" 부분을 제거
        } else {
            separator = ",|:"; // 기본 구분자 설정
        }
        return input.split(separator); // 구분자로 문자열 분리
    }
}
