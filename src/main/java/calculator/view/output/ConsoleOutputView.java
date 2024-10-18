package calculator.view.output;

public class ConsoleOutputView implements OutputView {

    @Override
    public void displayOutput(final int output) {
        System.out.println("결과 : " + output);
    }
}
