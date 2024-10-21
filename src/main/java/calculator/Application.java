package calculator;

public class Application {
    public static void main(String[] args) {
        InputReader inputReader = new InputReader();
        StringCalculator calculator = new StringCalculator();
        OutputPrinter outputPrinter = new OutputPrinter();

        // 사용자의 입력을 받는 기능
        String input = inputReader.promptForInput();

        // 계산하는 기능
        int result = calculator.calculateSum(input);

        // 결과를 출력하는 기능
        outputPrinter.displayResult(result);
    }
}
