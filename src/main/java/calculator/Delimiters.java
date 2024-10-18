package calculator;

import java.util.List;

/**
 * - 역할: 기본 구분자와 커스텀 구분자를 처리하여 문자열을 정규 표현식으로 변환
 * - 책임: 커스텀 구분자가 있는 경우 이를 파악하고, 적절한 구분자를 이용해 정규 표현식을 생성
 */
public class Delimiters {
    private static final String LEFT_BRACKET = "[";
    private static final String RIGHT_BRACKET = "]";
    private static final String BAR = "|";
    private static final String STARTS_WITH = "^";
    private static final String NUMBER_ONE_OR_MORE = "[0-9]+";
    private static final String ZERO_OR_MORE_AT_END = "*$";
    private static final String GROUP_START = "(";
    private static final String GROUP_END = ")";
    private static final String CUSTOM_DELIMITER_EXTRACTION_REGEX = "//|\\Q\\n\\E";
    private static final String CUSTOM_DELIMITER_REGEX = "^//[^a-zA-Z0-9]\\Q\\n\\E.*";

    private final List<String> delimiters;
    private final String customDelimiter;

    /**
     * 생성자: 기본 구분자 리스트와 입력된 문자열을 받아 커스텀 구분자를 설정
     * @param defaultDelimiters 기본 구분자 리스트
     * @param input 사용자 입력 문자열
     */
    public Delimiters(String input, List<String> defaultDelimiters) {
        this.delimiters = defaultDelimiters;
        this.customDelimiter = getCustomDelimiter(input);
    }

    public boolean isCustomDelimiterPresent() {
        return !customDelimiter.isEmpty();
    }


    public String generateRegexForDefaultDelimiters() {
        return LEFT_BRACKET + regexForDefault() + RIGHT_BRACKET;
    }

    public String generateRegexForCustomDelimiter() {
        return LEFT_BRACKET + regexForDefault() + BAR + customDelimiter + RIGHT_BRACKET;
    }

    /**
     * 커스텀 구분자를 포함한 문자열의 유효성 검사를 위한 정규 표현식 생성
     * - 커스텀 구분자를 이용해 숫자 패턴이 맞는지 검사
     * @return 숫자 패턴을 포함한 정규 표현식
     */
    public String regexForCustomPattern() {
        return STARTS_WITH + NUMBER_ONE_OR_MORE + GROUP_START + generateRegexForCustomDelimiter() + NUMBER_ONE_OR_MORE + GROUP_END + ZERO_OR_MORE_AT_END;
    }

    /**
     * 기본 구분자만 사용하는 문자열의 유효성 검사를 위한 정규 표현식 생성
     * - 기본 구분자를 이용해 숫자 패턴이 맞는지 검사
     * @return 숫자 패턴을 포함한 정규 표현식
     */
    public String regexForDefaultPattern() {
        return STARTS_WITH + NUMBER_ONE_OR_MORE + GROUP_START + generateRegexForDefaultDelimiters() + NUMBER_ONE_OR_MORE + GROUP_END  + ZERO_OR_MORE_AT_END;
    }


    /**
     * 커스텀 구분자를 추출하는 메서드
     * - 입력 문자열에서 "//"와 "\n" 사이의 문자열을 구분자로 추출
     * @param input 사용자 입력 문자열
     * @return 추출된 커스텀 구분자
     */
    private String getCustomDelimiter(String input) {
        if(isCustomDelimiterPresent(input)){
            String[] customString = input.split(CUSTOM_DELIMITER_EXTRACTION_REGEX);
            return customString[1];
        }
        return "";
    }

    /**
     * 커스텀 구분자가 있는지 판단하는 메서드
     * - "//"로 시작하고 구분자 정의 후 "\n"이 포함된 형식인지를 검사
     * @param input 사용자 입력 문자열
     * @return 커스텀 구분자가 있으면 true 반환
     */
    private boolean isCustomDelimiterPresent(String input) {
        return input.matches(CUSTOM_DELIMITER_REGEX);
    }


    private String regexForDefault() {
        return String.join(BAR, delimiters);
    }
}
