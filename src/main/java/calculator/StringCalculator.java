package calculator;

import java.util.List;

public class StringCalculator {

    private final DelimiterExtractor delimiterExtractor;
    private final StringValidator stringValidator;
    private final NumberParser numberParser;

    public StringCalculator(DelimiterExtractor delimiterExtractor, StringValidator stringValidator, NumberParser numberParser) {
        this.delimiterExtractor = delimiterExtractor;
        this.stringValidator = stringValidator;
        this.numberParser = numberParser;
    }

    public long calculate(String string) {
        // 구분자 리스트 추출
        List<Character> delimiterList = delimiterExtractor.extract(string);

        // 커스텀 구분자 prefix 제거
        String trimmedString = string;
        if (delimiterList.size() > 2) {
            trimmedString = string.substring(5);
        }

        // 문자열 검사
        stringValidator.validate(trimmedString, delimiterList);

        // 문자열 나누기
        List<Long> numbers = numberParser.parse(trimmedString, delimiterList);

        return 0L;
    }

}
