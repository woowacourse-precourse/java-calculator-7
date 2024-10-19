package controller;

import calculator.Calculator;
import view.InputView;
import view.OutputView;

public class Controller {

    private final Calculator calculator;
    private final InputView inputView;
    private final OutputView outputView;

    // 생성자를 통한 의존성 주입
    public Controller(Calculator calculator, InputView inputView, OutputView outputView) {
        this.calculator = calculator;
        this.inputView = inputView;
        this.outputView = outputView;
    }

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
