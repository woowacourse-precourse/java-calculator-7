package calculator;

import java.util.List;

public class StringCalculator {

    private final DelimiterExtractor delimiterExtractor;
    private final StringValidator stringValidator;

    public StringCalculator(DelimiterExtractor delimiterExtractor, StringValidator stringValidator) {
        this.delimiterExtractor = delimiterExtractor;
        this.stringValidator = stringValidator;
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

        return 0L;
    }

}
