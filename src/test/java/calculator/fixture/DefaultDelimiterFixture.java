package calculator.fixture;

public enum DefaultDelimiterFixture implements SuccessDelimiterFixture {
    쉼표("1,2,3", 6),
    콜론("1:2:3", 6),
    ;

    private final String input;
    private final int result;

    DefaultDelimiterFixture(String input, int result) {
        this.input = input;
        this.result = result;
    }

    @Override
    public String getInput() {
        return input;
    }

    @Override
    public String getResult() {
        return String.format("결과 : %d", result);
    }
}
