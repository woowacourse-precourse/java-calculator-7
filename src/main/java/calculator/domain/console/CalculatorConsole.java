package calculator.domain.console;

import calculator.domain.calculator.presentation.StringCalculatorController;
import calculator.domain.calculator.service.StringCalculatorService;
import calculator.domain.console.util.ConsoleReader;
import calculator.domain.console.util.ConsoleWriter;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorConsole {

    private final String DATE_REQUEST_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private final String RESULT_MESSAGE = "결과 :";

    private final StringCalculatorService service = StringCalculatorService.getInstance();
    private final StringCalculatorController controller = StringCalculatorController.getInstance(service);

    public void run() {

        ConsoleWriter.write(DATE_REQUEST_MESSAGE);
        final String read = ConsoleReader.read();

        try {
            int result = controller.calculateString(read);
            System.out.println("계산 결과: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("오류: " + e.getMessage());
        }
    }
}
