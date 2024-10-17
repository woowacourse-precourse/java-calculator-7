package calculator.parsing;

import calculator.extractor.DelimiterExtractor;
import calculator.extractor.NumberExtractor;

public class UserInputParser {

    private final DelimiterExtractor delimiterExtractor;
    private final NumberExtractor numberExtractor;

    public UserInputParser(DelimiterExtractor delimiterExtractor, NumberExtractor numberExtractor) {
        this.delimiterExtractor = delimiterExtractor;
        this.numberExtractor = numberExtractor;
    }

    public String[] parseInput(String input) {

        if (input.length() > 50) {
            throw new IllegalArgumentException("입력 길이 제한을 초과했습니다.");
        }

        String delimiter = delimiterExtractor.extractDelimiter(input);
        String numbersPart = numberExtractor.extractNumbersPart(input);

        // split 결과를 배열로 받음
        String[] parts = numbersPart.split(delimiter, -1);

        for (String part : parts) {
            if (part.isEmpty()) {
                throw new IllegalArgumentException("잘못된 입력 형식: 연속된 구분자는 허용되지 않습니다.");
            }
        }

        return parts;
    }

}
