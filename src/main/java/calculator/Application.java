package calculator;

public class Application {
    public static void main(String[] args) {

        // 입력받기
        InputHandler inputHandler = new InputHandler();
        String input = inputHandler.read();

        // 커스텀 구분자 구하기
        Delimiter delimiter = new Delimiter();
        String[] inputExceptForCustomDelimiterAndCustomDelimiter = delimiter.findDelimiter(input);
        String[] strings = delimiter.devisionString(inputExceptForCustomDelimiterAndCustomDelimiter);

        // 합 구하기
        Calculator calculator = new Calculator();
        int sum = calculator.getSum(strings);

        // 출력하기
        OutputHandler outputHandler = new OutputHandler();
        outputHandler.print(sum);
    }
}
