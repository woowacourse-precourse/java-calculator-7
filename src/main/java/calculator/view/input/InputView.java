package calculator.view.input;

public abstract class InputView {  // 최소한의 책임만을 가짐

    public String readInput() {
        final String input = inputString();
        validateNotNull(input);
        return input;
    }

    protected abstract String inputString();

    private void validateNotNull(final String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력값이 null 일 수 없습니다.");
        }
    }
}
