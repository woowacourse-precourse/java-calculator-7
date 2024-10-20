package calculator.domain.delimiter_input;

import java.util.regex.Pattern;

/**
 * DelimiterInput 클래스는 구분자 패턴과 입력 문자열을 저장하며, 입력값이 유효한지 검증하는 역할을 합니다.
 */
public class DelimiterInput {
    // 구분자 패턴을 지정하는 템플릿, 기본 구분자는 쉼표(,)와 콜론(:)이 포함됨
    protected static final String DELIMITER_PATTERN_TEMPLATE = "[,:%s]";
    // 유효한 입력을 확인하기 위한 정규 표현식 템플릿
    protected static final String VALID_INPUT_PATTERN_TEMPLATE = "^[1-9][0-9]*(%s[1-9][0-9]*)*$";
    // 입력이 유효하지 않은 경우 던지는 예외 메시지
    protected static final String ERROR_MESSAGE = "양수와 구분자로 이루어진 문자열을 입력하세요.";

    protected String delimiterPattern;
    protected String input;

    /**
     * DelimiterInput 생성자입니다. 구분자 패턴과 입력 문자열을 받아서 초기화합니다.
     * 생성 시 입력값의 유효성을 검증합니다.
     *
     * @param delimiterPattern 구분자를 나타내는 정규 표현식
     * @param input            사용자로부터 입력받은 계산할 문자열
     */
    public DelimiterInput(String delimiterPattern, String input) {
        validate(delimiterPattern, input);  // 유효성 검증
        this.delimiterPattern = delimiterPattern;
        this.input = input;
    }

    /**
     * 구분자 패턴을 반환합니다.
     *
     * @return 구분자 패턴 문자열
     */
    public String getDelimiterPattern() {
        return delimiterPattern;
    }

    /**
     * 입력된 계산할 문자열을 반환합니다.
     *
     * @return 입력 문자열
     */
    public String getInput() {
        return input;
    }

    /**
     * 입력된 문자열이 구분자 패턴에 맞는 유효한 형식인지 검증합니다.
     * 유효하지 않은 경우 IllegalArgumentException을 발생시킵니다.
     */
    private void validate(String delimiterPattern, String input) {
        String validInputPattern = String.format(VALID_INPUT_PATTERN_TEMPLATE, delimiterPattern);

        // 입력이 유효하지 않으면 예외 발생
        if (!Pattern.matches(validInputPattern, input)) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
}
