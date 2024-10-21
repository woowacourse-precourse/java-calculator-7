package calculator;

import calculator.controller.CalculatorController;
import calculator.service.CalculatorService;
import calculator.view.CalculatorView;
import calculator.view.InputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        run(new Scanner(System.in));
    }

    // 테스트를 위한 정적 메서드 추가
    public static void run(Scanner scanner) {
        InputView inputView = new InputView(scanner);
        CalculatorService calculatorService = new CalculatorService();
        CalculatorController calculatorController = new CalculatorController(calculatorService);

        while (true) {
            String input = inputView.getInput();

            if (input == null || input.equalsIgnoreCase("exit")) {
                break;
            }

            try {
                String result = calculatorController.handleRequest(input);
                CalculatorView.displayResult(result);
            } catch (IllegalArgumentException e) {
                CalculatorView.displayError(e.getMessage());
                // 예외를 다시 던지는 대신에 continue로 루프를 이어서 계속 입력받도록 함
            }
        }
    }
}
