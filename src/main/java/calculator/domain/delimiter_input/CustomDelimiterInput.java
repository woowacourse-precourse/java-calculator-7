package calculator.domain.delimiter_input;

import calculator.Input;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * CustomDelimiterInput 클래스는 커스텀 구분자를 사용하는 입력 문자열을 처리하는 클래스입니다.
 * 입력 문자열에 커스텀 구분자가 포함된 경우 이를 파싱하여 구분자와 계산할 문자열을 추출합니다.
 */
public class CustomDelimiterInput extends DelimiterInput {

    // 커스텀 구분자 패턴을 나타내는 정규 표현식
    private static final String VALID_CUSTOM_DELIMITER_PATTERN = "//(?<customDelimiter>.)\\\\n(?<input>.+)";

    /**
     * CustomDelimiterInputInfo는 커스텀 구분자와 입력 문자열을 저장하는 내부 클래스입니다.
     * 또한, 입력 문자열의 유효성을 검증하고 매칭된 결과를 반환하는 기능을 제공합니다.
     */
    private record CustomDelimiterInputInfo(String customDelimiter, String input) {

        /**
         * 입력 문자열이 유효한 커스텀 구분자 패턴을 따르는지 검증합니다.
         *
         * @param input 검사할 Input 객체
         */
        private static void validate(Input input) {
            Pattern validCustomDelimiterPattern = Pattern.compile(VALID_CUSTOM_DELIMITER_PATTERN);
            Matcher matcher = validCustomDelimiterPattern.matcher(input.input());

            if (!matcher.find()) {
                throw new IllegalArgumentException(ERROR_MESSAGE);
            }
        }

        /**
         * 입력 문자열에서 커스텀 구분자와 입력 부분을 추출하는 Matcher를 반환합니다.
         *
         * @param input 검사할 Input 객체
         * @return 커스텀 구분자와 입력 문자열을 포함한 Matcher 객체
         */
        private static Matcher getMatcher(Input input) {
            Pattern validCustomDelimiterPattern = Pattern.compile(VALID_CUSTOM_DELIMITER_PATTERN);
            Matcher matcher = validCustomDelimiterPattern.matcher(input.input());

            if (!matcher.find()) {
                throw new IllegalArgumentException(ERROR_MESSAGE);
            }

            return matcher;
        }
    }

    /**
     * CustomDelimiterInput 생성자입니다. 커스텀 구분자와 입력 문자열을 추출하여 DelimiterInput을 초기화합니다.
     *
     * @param input 사용자로부터 입력받은 계산할 문자열을 포함하는 Input 객체
     */
    public CustomDelimiterInput(Input input) {
        super(getDelimiterPattern(input), getInputString(input));
    }

    /**
     * 입력된 Input 객체에서 커스텀 구분자 패턴을 추출하여 반환합니다.
     *
     * @param input 사용자로부터 입력받은 계산할 문자열을 포함하는 Input 객체
     * @return 커스텀 구분자 패턴 문자열
     */
    private static String getDelimiterPattern(Input input) {
        CustomDelimiterInputInfo info = getCustomDelimiterInputInfo(input);
        return String.format(DELIMITER_PATTERN_TEMPLATE, info.customDelimiter);
    }

    /**
     * 입력된 Input 객체에서 계산할 문자열 부분을 추출하여 반환합니다.
     *
     * @param input 사용자로부터 입력받은 계산할 문자열을 포함하는 Input 객체
     * @return 계산할 입력 문자열
     */
    private static String getInputString(Input input) {
        CustomDelimiterInputInfo info = getCustomDelimiterInputInfo(input);
        return info.input;
    }

    /**
     * 입력된 Input 객체에서 커스텀 구분자와 입력 문자열을 추출하여 CustomDelimiterInputInfo 객체로 반환합니다.
     *
     * @param input 사용자로부터 입력받은 계산할 문자열을 포함하는 Input 객체
     * @return 커스텀 구분자와 입력 문자열을 포함한 CustomDelimiterInputInfo 객체
     */
    private static CustomDelimiterInputInfo getCustomDelimiterInputInfo(Input input) {
        CustomDelimiterInputInfo.validate(input);  // 유효성 검증
        Matcher matcher = CustomDelimiterInputInfo.getMatcher(input);
        return new CustomDelimiterInputInfo(matcher.group("customDelimiter"), matcher.group("input"));
    }
}
