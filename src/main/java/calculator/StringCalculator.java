package calculator;

import java.util.Objects;

public class StringCalculator {

    private final DelimiterExtractor delimiterExtractor;
    private final NumberProcessor numberProcessor;

    public StringCalculator(DelimiterExtractor delimiterExtractor, NumberProcessor numberProcessor) {
        this.delimiterExtractor = delimiterExtractor;
        this.numberProcessor = numberProcessor;
    }

    public int calculate(String input) {
        if (Objects.equals(input, "\n") || Objects.equals(input, "")) {
            return numberProcessor.processNumbers(new String[]{"null"});
        }

        DelimiterResult delimiter = delimiterExtractor.extractDelimiter(input); // 구분자 추출

        String calculationTarget = input.substring(delimiter.getStartIndex()); // 입력된 문자열에서 연산 문자열 추출

        String[] numbers = calculationTarget.split(delimiter.getDelimiter());  // 구분자를 기준으로 숫자 분리

        return numberProcessor.processNumbers(numbers);  // 분리된 숫자 연산 처리
    }
}