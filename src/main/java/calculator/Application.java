package calculator;


public class Application {
    public static void main(String[] args) {
        new Application().run();
    }

    public void run() {
        // 1. 문자열을 입력 받음.
        InputReader inputReader = new InputReader();
        String input = inputReader.getInput();

        // '\\n'을 실제 개행 문자 '\n'으로 변환
        input = input.replace("\\n", "\n");

        // 2. 입력값을 검증.
        Validator validator = new Validator();
        validator.validateInput(input);

        // 3. 검증된 입력값을 계산
        Calculator calculator = new Calculator();
        int result = calculator.sumNumbers(input);

        // 4. 출력
        OutputPrinter outputPrinter = new OutputPrinter();
        outputPrinter.printResult(result);
    }
}
