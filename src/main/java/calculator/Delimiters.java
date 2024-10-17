package calculator;

import java.util.List;

/**
 * - 역할: 기본 구분자와 커스텀 구분자를 처리하여 문자열을 정규 표현식으로 변환
 * - 책임: 커스텀 구분자가 있는 경우 이를 파악하고, 적절한 구분자를 이용해 정규 표현식을 생성
 */
public class Delimiters {
    private final List<String> delimiters;
    private final String customDelimiter;


    /**
     * 생성자: 기본 구분자 리스트와 입력된 문자열을 받아 커스텀 구분자를 설정
     * @param defaultDelimiters 기본 구분자 리스트
     * @param input 사용자 입력 문자열
     */
    public Delimiters(List<String> defaultDelimiters, String input) {
        this.delimiters = defaultDelimiters;
        this.customDelimiter = getCustomDelimiter(input);
    }

    public boolean isCustomDelimiterPresent() {
        return !customDelimiter.isEmpty();
    }


    public String generateDefaultDelimiterRegex() {
        return "[" + regexForDefault() + "]";
    }

    public String generateCustomDelimiterRegex() {
        return "[" + regexForDefault() + "|" + customDelimiter + "]";
    }

    /**
     * 커스텀 구분자를 포함한 문자열의 유효성 검사를 위한 정규 표현식 생성
     * - 커스텀 구분자를 이용해 숫자 패턴이 맞는지 검사
     * @return 숫자 패턴을 포함한 정규 표현식
     */
    public String regexForCustomPatten() {
        return "^[0-9]+("+ generateCustomDelimiterRegex() +"[0-9]+)*$";
    }

    /**
     * 기본 구분자만 사용하는 문자열의 유효성 검사를 위한 정규 표현식 생성
     * - 기본 구분자를 이용해 숫자 패턴이 맞는지 검사
     * @return 숫자 패턴을 포함한 정규 표현식
     */
    public String regexForDefaultPattern() {
        return "^[0-9]+("+ generateDefaultDelimiterRegex() +"[0-9]+)*$";
    }


    /**
     * 커스텀 구분자를 추출하는 메서드
     * - 입력 문자열에서 "//"와 "\n" 사이의 문자열을 구분자로 추출
     * @param input 사용자 입력 문자열
     * @return 추출된 커스텀 구분자
     */
    private String getCustomDelimiter(String input) {
        if(isCustomDelimiterPresent(input)){
            String regex = "//|\\Q\\n\\E";
            String[] customString = input.split(regex);
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
        String regex = "^//[^a-zA-Z0-9]\\Q\\n\\E.*";
        return input.matches(regex);
    }


    private String regexForDefault() {
        return String.join("|", delimiters);
    }
}
