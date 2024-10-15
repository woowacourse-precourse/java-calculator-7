package calculator;

public class Calculator {

    InputView inputView;

    public Calculator(InputView inputView) {
        this.inputView = inputView;
    }

    public int sum() {
        return inputView.readNumbers().stream().mapToInt(Integer::intValue).sum();
    }
}
