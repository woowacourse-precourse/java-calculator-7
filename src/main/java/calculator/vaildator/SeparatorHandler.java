package calculator.vaildator;

import java.util.regex.Pattern;

public class SeparatorHandler {

    // 사용자 지정 구분자를 추출하는 메서드
    public String getCustomSeparator(String input) {

        if (!input.matches("//.+\\\\n.*")) {
            throw new IllegalArgumentException("구분자를 정확하게 입력해주세요.");
        }

        // 구분자 추출: 두 번째 위치의 문자가 구분자
        String separator = input.substring(2, input.indexOf("\\n"));

        // 구분자 유효성 검사
        validateSeparator(separator);

        // 사용자 정의 구분자를 반환
        return separator;
    }

    // 입력 문자열을 구분자 기준으로 분리하는 메서드
    public String[] splitInput(String input, String separator) {
        // 사용자 정의 구분자가 있을 경우
        if (separator != null && !separator.isEmpty()) {
            // 사용자 정의 구분자를 제외한 나머지 문자열
            int separatorEndIndex = input.indexOf("\\n") + 2; // \n의 인덱스를 찾아서 그 뒤부터 처리
            input = input.substring(separatorEndIndex); // 구분자와 \n을 제외한 나머지 문자열

            return splitByCustomSeparator(input, separator);
        }

        // 기본 구분자 ','와 ':'로 분리
        return splitByDefaultSeparators(input);
    }

    // 사용자 정의 구분자로 분리하는 메서드
    private String[] splitByCustomSeparator(String input, String separator) {
        return input.split(Pattern.quote(separator) + "|[,:]");
    }

    // 기본 구분자 ','와 ':'로 분리하는 메서드
    private String[] splitByDefaultSeparators(String input) {
        return input.split("[,:]");
    }

    // 구분자 유효성을 검증하는 메서드
    private void validateSeparator(String separator) {
        // 구분자가 포함된 문자열에서 쉼표, 콜론 또는 숫자가 있는지 확인
        for (char c : separator.toCharArray()) {
            if (c == ',' || c == ':') {
                throw new IllegalArgumentException("기본 구분자를 커스텀 구분자로 사용할 수 없습니다.");
            }
            if (Character.isDigit(c)) {
                throw new IllegalArgumentException("숫자는 구분자로 사용할 수 없습니다.");
            }
        }
    }
}
