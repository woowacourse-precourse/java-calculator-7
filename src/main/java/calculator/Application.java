package calculator;

public class Application {
    public static void main(String[] args) {

        // 사용자 입력 받기
        String input = InputView.getInput();

        // 계산 수행
        Calculator calculator = new Calculator();
        int result = calculator.calculate(input);

        // 결과 출력
        OutputView.printResult(result);
    }
}
