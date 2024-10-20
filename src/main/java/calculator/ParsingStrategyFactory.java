package calculator;

/**
 * 입력에 따라 적절한 파싱 전략을 반환하는 팩토리 클래스입니다.
 * "//"로 시작하는 입력은 커스텀 파싱 전략을, 그 외의 경우는 기본 파싱 전략을 사용합니다.
 */
public class ParsingStrategyFactory {
    private static final String CUSTOM_PREFIX = "//";

    /**
     * 입력된 문자열에 따라 적절한 파싱 전략을 반환합니다.
     * @param input 사용자로부터 입력받은 문자열
     * @return 파싱 전략
     */
    public static ParsingStrategy getStrategy(String input) {
        if (input.startsWith(CUSTOM_PREFIX)) {
            return new CustomParsingStrategy();
        } else {
            return new DefaultParsingStrategy();
        }
    }
}
