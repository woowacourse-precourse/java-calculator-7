package calculator;

public class StringAddCalculator {
    private final Parser parser;
    private final Validator validator;
    private final Adder adder;

    public StringAddCalculator() {
        this.parser = new Parser();
        this.validator = new Validator();
        this.adder = new Adder();
    }

    public int add(String input) {
        // 문자열 파싱
        String[] parsedNumbers = parser.parse(input);

        // 예외 유효성 검사
        validator.validate(parsedNumbers);

        // 합 계산
        return adder.calculateSum(parsedNumbers);
    }
}
