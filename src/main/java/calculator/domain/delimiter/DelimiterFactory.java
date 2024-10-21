package calculator.domain.delimiter;

public class DelimiterFactory {

    private DelimiterFactory() {}

    public static Delimiter create(final String input) {
        Delimiter defaultDelimiter = new DefaultDelimiter(input);
        Delimiter customDelimiter = new CustomDelimiter(input);

        if (defaultDelimiter.matches()) {
            return defaultDelimiter;
        }
        if (customDelimiter.matches()) {
            return customDelimiter;
        }
        throw new IllegalArgumentException(inputPatternErrorMessage(input));
    }

    private static String inputPatternErrorMessage(final String input) {
        return String.join("은 ", input, """
                입력 형식에 맞지 않습니다.
                - 기본 구분자는 쉼표(,)와 콜론(:)을 사용합니다. ex) 1,2:3
                - 커스텀 구분자는 //와 \\n 사이에 1~3개 문자를 입력해 사용합니다. ex) //;\\n1;2;3
                """
        );
    }

}
