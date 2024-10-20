package calculator.model;

public class Calculator {
    private final DelimiterParser delimiterParser;
    private final InputValidator inputValidator;
    private final NumberParser numberParser;

    public Calculator() {
        this.delimiterParser = new DelimiterParser();
        this.inputValidator = new InputValidator();
        this.numberParser = new NumberParser();
    }

    public int sum(String input) {
        // 빈 문자열 또는 공백 처리
        if (inputValidator.isEmpty(input)) {
            return 0;
        }

        // 구분자 파싱 및 숫자 분리
        String[] numbers = delimiterParser.parse(input);
        return numberParser.sum(numbers); // NumberParser의 sum 메서드 호출
    }
}
