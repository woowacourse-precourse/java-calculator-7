package calculator;

import java.util.List;
import java.util.Optional;

public class DelimiterCalculator implements Calculator {
    private final DelimiterExtractor delimiterExtractor;
    private final LineTokenizer lineTokenizer;

    public DelimiterCalculator(DelimiterExtractor delimiterExtractor, LineTokenizer lineTokenizer) {
        this.delimiterExtractor = delimiterExtractor;
        this.lineTokenizer = lineTokenizer;
    }

    @Override
    public int calculate(String input) {
        // 1.커스텀 구분자가 있는지 확인한다.
        Optional<Character> customDelimiter = delimiterExtractor.extract(input);

        // 2. 커스텀 구분자가 있으면, 구분자를 추가하고, input에서 커스텀 구분자를 제거한다.
        if (customDelimiter.isPresent()) {
            lineTokenizer.addDelimiter(customDelimiter.get());
            input = input.substring(delimiterExtractor.getExtractHeaderLength());
        }

        // 3. input을 구분자로 나누어 숫자로 변환한다.
        List<Integer> numbers = lineTokenizer.tokenize(input);

        // 4. 숫자들의 합을 구한다.
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }

}
