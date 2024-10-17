package calculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 사용자로부터 문자열 입력 받기
        InputView inputView = new InputView();

        // 입력 받은 문자열 내부 숫자들의 합 구하기
        Calculator calculator = new Calculator(inputView.getUserInput());

        // 계산 결과 출력
        OutputView outputView = new OutputView();
        outputView.printSum(calculator.getSum());
    }
}
