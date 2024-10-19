package calculator;

public class InputValidator {

    public boolean isValid(String input) {

        if (input == null || input.isEmpty()) {
            return true; // 빈 문자열은 유효한 입력으로 처리
        }

        // 기본 구분자(쉼표, 콜론)를 사용하는 경우
        if (input.matches("[0-9]+([,:][0-9]+)*")) {
            return true;
        }

        // 커스텀 구분자를 포함할 때
        if (isValidCustom(input)) {
            // 커스텀 구분자 추출
            String delimiter = extractDelimiter(input);

            String escapedDelimiter = delimiter.replaceAll("([\\W])", "\\\\$1");

            // 커스텀 구분자와 기본 구분자를 모두 처리하는 정규식 패턴
            String pattern = "//" + delimiter + "\\\\n([0-9]+([," + delimiter + ":][0-9]+)*)?";

            if (input.matches(pattern)) {
                return true;
            }
        }
        return false;
    }

    public boolean isValidCustom(String input) {
        String regex = "^//.\\\\n.*";
        return input.matches(regex);
    }

    private String extractDelimiter(String input) {
        int newlineIndex = input.indexOf("\\n");
        return input.substring(2, newlineIndex); // "//" 뒤의 구분자 추출
    }
}
