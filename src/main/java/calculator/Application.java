package calculator;

public class Application {
    public static void main(String[] args) {
        Input inputHandler = new Input();
        Output outputHandler = new Output();
        Calculator calculator = new Calculator();

        // 입력
        String input = inputHandler.getInput();

        // 계산
        int result = calculator.add(input);

        // 출력
        outputHandler.printResult(result);
    }
}
