package controller;

import calculator.Calculator;
import view.InputView;
import view.OutputView;

public class Controller {

    private final Calculator calculator = new Calculator();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void processUserInput() {
        while (true) {
            // 입력
            String userInput = inputView.readInput();

            // "exit" 입력 시 프로그램 종료
            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            // 비즈니스 로직
            int sum = calculator.processInputAndSum(userInput);

            // 출력
            outputView.printResult(sum);
        }
    }
}
