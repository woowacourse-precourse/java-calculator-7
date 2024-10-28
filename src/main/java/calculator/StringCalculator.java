package calculator;

import java.util.List;
import java.util.Set;

public class StringCalculator {

    private final DelimiterExtractor delimiterExtractor;
    private final StringValidator stringValidator;
    private final NumberParser numberParser;

    public StringCalculator(DelimiterExtractor delimiterExtractor,
                            StringValidator stringValidator,
                            NumberParser numberParser) {
        this.delimiterExtractor = delimiterExtractor;
        this.stringValidator = stringValidator;
        this.numberParser = numberParser;
    }

    public long calculate(String string) {
        // 구분자 리스트 추출
        Set<Character> delimiterList = delimiterExtractor.extract(string);

        // 커스텀 구분자 prefix 제거
        String trimmedString = removePrefix(string);

        // 문자열 검사
        stringValidator.validate(trimmedString, delimiterList);

        // 문자열 나누기
        List<Long> numbers = numberParser.parse(trimmedString, delimiterList);

        // 숫자의 합 반환하기
        return sum(numbers);
    }

    private long sum(List<Long> numbers) {
        return numbers.stream().reduce(0L, Long::sum);
    }

    private String removePrefix(String string) {
        if (string.startsWith("//") && string.startsWith("\\n", 3)) {
            return string.substring(5);
        }

        return string;
    }

}
