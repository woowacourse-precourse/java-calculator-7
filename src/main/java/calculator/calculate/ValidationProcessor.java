package calculator.calculate;

import java.util.ArrayList;
import java.util.List;

public class ValidationProcessor {

    private List<Integer> numbers;

    public ValidationProcessor() {
        this.numbers = new ArrayList<>();
    }

    public List<Integer> extractNumbers(String input) {
        // 빈 경우 0처리
        if (input.isEmpty()) {
            this.numbers.add(0);
            return this.numbers;
        }

        // 구분자 찾기
        SeparatorParser separatorParser = new SeparatorParser();
        List<String> separators = separatorParser.findSeparator(input);

        if (input.startsWith("//")) {
            input = separatorParser.removeSuffix(input);
        }

        // 숫자 추출
        NumberExtractor numberExtractor = new NumberExtractor();
        this.numbers = numberExtractor.extractNumbers(input, separators);

        return this.numbers;
    }


}
