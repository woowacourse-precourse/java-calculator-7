package calculator;

import java.util.Optional;

/**
 * 사용자가 지정한 "//" 와 "\n" 사이에 존재하는 커스텀 구분문자 추출하여 retyrn 한다.
 */

public class CustomExtractor {
    private final String customPrefix;
    private final String customSuffix;

    public record ExtractedCharAndString(Character customDelimiter, String extracted) {
    }

    public CustomExtractor(String customPrefix, String customSuffix) {
        this.customPrefix = customPrefix;
        this.customSuffix = customSuffix;
    }

    /**
     * 커스텀 구분자가 존재하는 입력이라면 추출하고 검증하여 반환한다
     *
     * @param input 사용자의 입력값
     * @return 커스텀 구분자
     */
    public Optional<ExtractedCharAndString> extractCustomDelimiter(String input) {

        if (input.isBlank()) {
            throw new IllegalArgumentException("구분자와 숫자를 입력하세요.");
        }
        if (!input.startsWith(customPrefix)) {
            return Optional.empty();
        }
        if (input.length() < customPrefix.length() + customSuffix.length() + 1) {
            throw new IllegalArgumentException("커스텀 구분자와 최소 하나 이상의 숫자를 입력하세요.");
        }

        String custom = extractCustomPart(input);
        validateLength(custom);
        return Optional.of(new ExtractedCharAndString(extractChar(custom), input.substring(custom.length())));
    }

    /**
     * 커스텀 구분자가 존재하는 입력이라면 커스텀 구분자를 의미하는 문자열의 부분을 제거하고 반환한다
     *
     * @param input 커스텀 구분자를 포함하는 사용자의 유효한 입력값
     * @return 커스텀 구분자와 관련된 문자열 부분을 제거한 입력 문자열
     */
    private String extractCustomPart(String input) {
        String customPart = "";
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == customSuffix.charAt(0)) {
                if (input.charAt(i + 1) == customSuffix.charAt(1)) {
                    break;
                }
            }
            customPart += input.charAt(i);
        }

        return customPart + customSuffix;
    }

    /**
     * 커스텀 구분자가 하나인지 검증한다
     *
     * @param custom 커스텀 구분자를 위해 추출한 파트
     */
    private void validateLength(String custom) {
        if (custom.length() != (customSuffix.length() + customPrefix.length() + 1)) {
            throw new IllegalArgumentException("커스텀 구분자는 한 글자 문자여야합니다.");
        }
    }

    /**
     * 커스텀 구분자 추출한다
     *
     * @param custom 커스텀 구분자를 위해 추출한 파트
     * @return 커스텀 구분자
     */
    private Character extractChar(String custom) {
        char delimiter = custom.charAt(customPrefix.length());
        validateChar(delimiter);
        return delimiter;
    }

    /**
     * 숫자가 아닌 문자인지 검증한다
     *
     * @param custom 검증할 문자열
     */
    private void validateChar(char custom) {
        if (Character.isDigit(custom)) {
            throw new IllegalArgumentException("커스텀 구분자는 숫자가 될 수 없습니다.");
        }
    }
}
