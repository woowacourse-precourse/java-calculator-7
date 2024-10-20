package calculator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static calculator.AppConfig.CUSTOM_DELIMITER_END;
import static calculator.AppConfig.CUSTOM_DELIMITER_START;


/**
 * - 역할: 기본 구분자와 커스텀 구분자를 처리하여 문자열을 정규 표현식으로 변환
 * - 책임: 커스텀 구분자가 있는 경우 이를 파악하고, 적절한 구분자를 이용해 정규 표현식을 생성
 */
public class Delimiters {
    private static final String OR_OPERATOR = "|";
    private static final Pattern isCustomDelimiterPresent= Pattern.compile("^" + CUSTOM_DELIMITER_START + "[^a-zA-Z0-9]" + CUSTOM_DELIMITER_END + ".*");
    private static final Pattern splitBetweenCustomDelimiters = Pattern.compile(CUSTOM_DELIMITER_START + "(.*?)" + CUSTOM_DELIMITER_END);

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
        isCustomDelimiterValid(customDelimiter);
    }

    public boolean isCustomDelimiterPresent() {
        return !customDelimiter.isEmpty();
    }

    public Pattern getCustomDelimiterPattern() {
        return Pattern.compile("^[0-9]+([" + regexForDefault() + OR_OPERATOR + customDelimiter + "][0-9]+)*$");
    }
    public Pattern getDefaultDelimiterPattern() {
        return Pattern.compile("^[0-9]+([" + regexForDefault() + "][0-9]+)*$");
    }
    public Pattern getDefaultDelimiterForSplit() {
        return Pattern.compile("[" + regexForDefault()+ "]");
    }
    public Pattern getCustomDelimiterForSplit() {
        return Pattern.compile("[" + regexForDefault() + OR_OPERATOR + customDelimiter + "]");
    }

    /**
     * 커스텀 구분자가 있는지 판단하는 메서드
     * - "//"로 시작하고 구분자 정의 후 "\n"이 포함된 형식인지를 검사
     * @param input 사용자 입력 문자열
     * @return 커스텀 구분자가 있으면 true 반환
     */
    private boolean isCustomDelimiterPresent(String input) {
        return isCustomDelimiterPresent.matcher(input).matches();
    }


    private String regexForDefault() {
        return String.join(OR_OPERATOR, delimiters);
    }


    /**
     * 커스텀 구분자를 추출하는 메서드
     * - 입력 문자열에서 "//"와 "\n" 사이의 문자열을 구분자로 추출
     * @param input 사용자 입력 문자열
     * @return 추출된 커스텀 구분자
     */
    private String getCustomDelimiter(String input) {
        if(isCustomDelimiterPresent(input)){
            Matcher matcher = splitBetweenCustomDelimiters.matcher(input);
            if (matcher.find()) {
                return matcher.group(1);
            }
        }
        return "";
    }

    /**
     * - 커스텀 구분자가 기존 구분자와 동일할 경우 예외 발생
     * @param customDelimiter 추출된 커스텀 구분자
     */
    private void isCustomDelimiterValid(String customDelimiter) {
        if(delimiters.contains(customDelimiter)){
            throw new IllegalArgumentException("Delimiter '" + customDelimiter + "' already exists");
        }
    }

}
