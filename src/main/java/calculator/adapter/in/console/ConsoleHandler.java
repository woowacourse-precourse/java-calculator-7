package calculator.adapter.in.console;

import calculator.application.in.CalculateUseCase;
import calculator.domain.CalculateExpression;
import camp.nextstep.edu.missionutils.Console;

public class ConsoleHandler {

    private final CalculateUseCase calculateUseCase;

    public ConsoleHandler(CalculateUseCase calculateUseCase) {
        this.calculateUseCase = calculateUseCase;
    }

    public void calculateFromLine() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String line = Console.readLine().strip();

        Long answer = calculateUseCase.calculate(CalculateExpression.fromString(line));
        System.out.printf("결과 : %d\n", answer);
    }
}
