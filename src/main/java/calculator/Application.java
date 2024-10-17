package calculator;

public class Application {
    public static void main(String[] args) {
        Input inputHandler = new Input();
        Output outputHandler = new Output();
        Validator validator = new Validator();
        Delimiter delimiter = new Delimiter();
        Converter converter = new Converter();
        Adder adder = new Adder();
        Calculator calculator = new Calculator(validator, delimiter, converter, adder);

        // 입력
        String input = inputHandler.getInput();

        // 계산
        int result = calculator.calculate(input);

        // 출력
        outputHandler.printResult(result);
    }
}
