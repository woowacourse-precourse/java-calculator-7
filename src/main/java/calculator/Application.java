package calculator;

public class Application {
    public static void main(String[] args) {
        InputReader reader = new InputReader();
        InputParser parser = new InputParser();
        StringCalculator calculator = new StringCalculator();
        OutputPrinter printer = new OutputPrinter();

        // 사용자의 입력을 받는 기능
        String input = reader.promptForInput();

        // 받은 입력을 파싱하는 기능
        String[] tokens = parser.parseTokens(input);

        // 계산하는 기능
        int result = calculator.calculateSum(tokens);

        // 결과를 출력하는 기능
        printer.displayResult(result);
    }
}