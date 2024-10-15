package calculator;

public class Input {
    private final String str;

    public Input(String input) {
        validateStr(input);
        this.str = input;
    }

    private void validateStr(String input) {
        if (!input.matches("[0-9,:\\/\\/\\\\n]+")) {
            throw new IllegalArgumentException("잘못된 입력으로 프로그램이 종료됩니다. 숫자, 콤마, :, //, \\n만 입력 가능합니다.");
        }
    }
}
