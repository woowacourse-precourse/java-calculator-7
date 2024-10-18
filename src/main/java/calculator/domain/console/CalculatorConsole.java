package calculator.domain.console;

import calculator.domain.calculator.presentation.StringCalculatorController;
import calculator.domain.calculator.service.StringCalculatorService;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorConsole {

    final StringCalculatorService service = StringCalculatorService.getInstance();
    final StringCalculatorController controller = StringCalculatorController.getInstance(service);

    public void run() {
        System.out.println("문자열 계산기를 시작합니다.");

        while (true) {
            System.out.print("계산할 문자열을 입력하세요 (종료: q): ");
            String input = Console.readLine();

            if ("q".equalsIgnoreCase(input)) {
                System.out.println("계산기를 종료합니다.");
                break;
            }

            try {
                int result = controller.calculateString(input);
                System.out.println("계산 결과: " + result);
            } catch (IllegalArgumentException e) {
                System.out.println("오류: " + e.getMessage());
            }

            System.out.println(); // 빈 줄 출력
        }
    }
}
