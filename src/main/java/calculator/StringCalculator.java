package calculator;

import java.util.List;

public class StringCalculator {

    private final DelimiterExtractor delimiterExtractor;


    public StringCalculator(DelimiterExtractor delimiterExtractor) {
        this.delimiterExtractor = delimiterExtractor;
    }

    public long calculate(String string) {
        // 구분자 리스트 추출
        List<Character> delimiterList = delimiterExtractor.extract(string);

        return 0L;
    }

}
