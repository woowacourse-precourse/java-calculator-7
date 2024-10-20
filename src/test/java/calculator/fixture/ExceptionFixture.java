package calculator.fixture;

public enum ExceptionFixture {
    음수1("1-2,3"),
    음수2("-1,2,3"),
    여러구분자("1,,2,3"),
    포함하지않는구분자("1!2,3"),
    존재하지않는커스텀구분자("//|\\n1!2,3");

    private final String invalidInput;

    ExceptionFixture(String invalidInput) {
        this.invalidInput = invalidInput;
    }

    public String getInvalidInput() {
        return invalidInput;
    }
}
