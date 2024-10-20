package calculator;

public class InputHandler {
    private static final String DEFAULT_DELIMITERS = ",|:"; // 기본 구분자
    private static final String CUSTOM_DELIMITER_PREFIX = "//"; // 커스텀 구분자 접두사
    private static final String CUSTOM_DELIMITER_END = "\\n"; // 커스텀 구분자 종료 문자

    public static String[] parse(String input) {
        String[] parsed = parseInput(input);
        checkInput(parsed);
        return parsed;
    }

    private static String[] parseInput(String input) {
        String delimiter = DEFAULT_DELIMITERS;
        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            int delimiterIndex = input.indexOf(CUSTOM_DELIMITER_END); // 실제 줄바꿈 인식
            if (delimiterIndex != -1) {
                String customDelimiter = input.substring(2, delimiterIndex).trim();
                customDelimiter = escapeMeta(customDelimiter);
                delimiter = customDelimiter + "|" + delimiter;
                String numbers = input.substring(delimiterIndex + 2).trim();
                return splitInput(numbers, delimiter);
            } else {
                throw new IllegalArgumentException("커스텀 구분자 지정 종료가 존재하지 않습니다: " + input);
            }
        }
        return input.split(delimiter);
    }

    private static String escapeMeta(String delimiter) {
        StringBuilder escaped = new StringBuilder();
        String metaCharacters = ".*+?^${}()|[]\\";
        for (char c : delimiter.toCharArray()) {
            if (metaCharacters.indexOf(c) != -1) {
                escaped.append("\\"); // 메타문자면 이스케이프 추가
            }
            escaped.append(c); // 문자 추가
        }
        return escaped.toString();
    }

    private static String[] splitInput(String input, String delimiter) {
        return input.split(delimiter);
    }

    private static void checkInput(String[] parseinput) {
        for (String strNum : parseinput) {
            if (strNum.equals("0")) {
                throw new IllegalArgumentException("숫자는 양수 외 입력은 할 수 없습니다.");
            }
            try {
                int intNum = Integer.parseInt(strNum);
            } catch (NumberFormatException e) { //음수의 경우도 '-'가 NumberFormatException에 해당됨
                throw new IllegalArgumentException("구분자 및 양수 외 입력은 할 수 없습니다.");
            }
        }
    }
}