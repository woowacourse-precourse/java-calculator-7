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
        String allDelimiter = "";
        while (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            int delimiterIndex = input.indexOf(CUSTOM_DELIMITER_END);
            if (delimiterIndex != -1) {
                String customDelimiter = input.substring(2, delimiterIndex).trim();
                customDelimiter = escapeMeta(customDelimiter);
                if (!allDelimiter.isEmpty()) {
                    allDelimiter += "|" + customDelimiter;  // 이미 추가된 경우
                } else {
                    allDelimiter = delimiter + "|" + customDelimiter; // 첫 번째 커스텀 구분자
                }
                input = input.substring(delimiterIndex + 2).trim();
                delimiter = allDelimiter;
            } else {
                throw new IllegalArgumentException("커스텀 구분자 지정 종료가 존재하지 않습니다");
            }
        }
        return splitInput(input, delimiter);
    }

    private static String escapeMeta(String delimiter) {
        StringBuilder escaped = new StringBuilder();
        String metaCharacters = ".*+?^${}()|[]\\";
        for (char c : delimiter.toCharArray()) {
            if (metaCharacters.indexOf(c) != -1) {
                escaped.append("\\"); // 메타문자면 이스케이프 추가
            }
            escaped.append(c);
        }
        return escaped.toString();
    }

    private static String[] splitInput(String input, String delimiter) {
        return input.split(delimiter);
    }

    private static void checkInput(String[] parseinput) {
        for (String strNum : parseinput) {
            if (strNum.equals("0")) {
                throw new IllegalArgumentException("숫자는 양수 외에는 입력은 할 수 없습니다.");
            }
            if (strNum.isEmpty()) {
                strNum = "0";
            }
            try {
                int intNum = Integer.parseInt(strNum);
                if (intNum < 0) {
                    throw new IllegalArgumentException("음수는 입력은 할 수 없습니다.");
                }
            } catch (NumberFormatException e) { //음수의 경우도 '-'가 NumberFormatException에 해당됨
                throw new IllegalArgumentException("공백 문자열 및 기타 문자열은 입력 할 수 없습니다.");
            }
        }
    }
}