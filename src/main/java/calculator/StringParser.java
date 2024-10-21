package calculator;

public class StringParser {
    public String[] parse(String input) {
        // 구분자 정의 `,` 혹은 `:`
        String delimiter = "[,:]";

        // 커스텀 구분자 처리
        if (input.startsWith("//")) {

            // \\n라고 적어야 `\`, `n` 검색 가능
            // \\는 escape 문자로, `\\`를 `\` 한 글자로 취급함
            int delimiterIndex = input.indexOf("\\n");

            // 커스텀 구분자 입력이 정상적으로 되었는지 확인
            if (delimiterIndex != -1) {
                String customDelimiter = input.substring(2, delimiterIndex);

                // `\`가 포함된 경우 예외 처리
                if (customDelimiter.contains("\\")) {
                    throw new IllegalArgumentException("구분자로 역슬래시(\\)는 사용할 수 없습니다.");
                }

                // 숫자인 경우 예외 처리
                if (isNumeric(customDelimiter)) {
                    throw new IllegalArgumentException("숫자는 구분자로 사용할 수 없습니다");
                }

                delimiter = escapeSpecialCharacters(customDelimiter);

                // 기존 방식: \n = 1글자 => Index + 1
                // 현재 방식: \\n = 2글자 => Index + 2 (escape 문자 고려)
                input = input.substring(delimiterIndex + 2);
            } else {
                throw new IllegalArgumentException("유효하지 않은 커스텀 구분자 형식입니다.");
            }
        }

        // 정의된 구분자로 문자열 처리
        return input.split(delimiter);
    }

    // 특수 문자 escape 처리
    private String escapeSpecialCharacters(String delimiter) {
        return delimiter.replaceAll("([\\[\\]\\{\\}\\(\\)\\*\\+\\?\\^\\$\\|\\.])", "\\\\$1");
    }

    // 숫자인지
    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
