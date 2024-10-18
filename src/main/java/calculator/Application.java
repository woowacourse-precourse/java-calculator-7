package calculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Calculate calculate = new Calculate();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        String input = inputView.userInput();
        int sum = calculate.splitString(input);
        outputView.print(sum);
    }
}
