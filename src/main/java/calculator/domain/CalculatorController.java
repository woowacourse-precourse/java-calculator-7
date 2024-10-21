package calculator.domain;

import calculator.util.Parser;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class CalculatorController {
    private static Calculator calculator;
    private static List<Integer> numbers;
    private static String userInput;
    private static int sum;

    public static void run() {
        // 사용자의 입력을 가공하여 정수 리스트로 저장
        saveUserInput();
        processUserInput();

        // 정수 리스트를 계산기에 저장
        calculator = calculator.of(numbers);

        // 계산기에서 합을 계산 및 반환
        processCalculation();

        // 결과를 유저에게 안내
        OutputView.printSum(sum);
    }

    private static void saveUserInput() {
        userInput = InputView.readUserInput();
    }

    private static void processUserInput() {
        numbers = new ArrayList<>(Parser.processString(userInput));
    }

    private static void processCalculation() {
        sum = calculator.calculateSum();
    }
}
