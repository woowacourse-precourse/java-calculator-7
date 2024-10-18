package calculator;

public class DelimiterHandler {
    String delimiter = "[,:]"; // 기본 구분자

    public String[] processCustomDelimiter(String input) {
        if (isCustomDelimiter(input)) {
            String customDelimiter = String.valueOf(input.charAt(2)); // 커스텀 구분자 추출
            delimiter = addDelimiter(delimiter, customDelimiter); // 기본 구분자에 커스텀 구분자 추가
            input = input.split("n")[1]; // 입력 문자열에서 커스텀 구분자 부분 제거
        }
        return new String[]{input, delimiter}; // 기본 구분자
    }

    private boolean isCustomDelimiter(String input) {
        return input.startsWith("//") && input.charAt(3) == '\\' && input.charAt(4) == 'n';
    }

    private String addDelimiter(String defaultDelimiter, String newDelimiter) {
        if (defaultDelimiter.contains(newDelimiter)) {
            return defaultDelimiter; // 중복된 경우 그대로 반환
        }
        return defaultDelimiter.substring(0, defaultDelimiter.length() - 1) + newDelimiter + "]"; // 새로운 구분자를 추가
    }
}