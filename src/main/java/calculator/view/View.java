package calculator.view;
import camp.nextstep.edu.missionutils.Console;

public class View {
    public String inputExpression() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        return Console.readLine();
    }

    public void printCalculationResult(Integer result) {
        System.out.printf("결과 : %d\n", result);
    }
}
