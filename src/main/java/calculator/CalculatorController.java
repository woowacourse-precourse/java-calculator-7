package calculator;

import java.util.Scanner;

public class CalculatorController {
    private final Calculator calculator;

    public CalculatorController(Calculator calculator) {
        this.calculator = calculator;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요:");
        String input = scanner.nextLine();

        int result = calculator.add(input);
        System.out.println("결과 : " + result);

    }
}
