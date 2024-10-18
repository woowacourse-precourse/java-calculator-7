package calculator.console;

import calculator.domain.Adder;
import calculator.domain.Separator;
import calculator.exception.ExceptionHandler;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorConsole {

    private String input;

    private Separator separator;
    private Adder adder;
    private ExceptionHandler exceptionHandler;

    public CalculatorConsole(Separator separator, Adder adder, ExceptionHandler exceptionHandler) {
        this.separator = separator;
        this.adder = adder;
        this.exceptionHandler = exceptionHandler;
    }

    //사용자로부터 문자를 입력받음
    String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        input = Console.readLine();
        System.out.println(input);
        return input;
    }

    //입력값이 유효한지 검증
    public boolean validateInput(String input) {
        try {
            exceptionHandler.throwExceptionIfInvalid(input);
            return true;
        } catch (IllegalArgumentException e) {
            exceptionHandler.handleInvalidInput(e.getMessage());
            return false;
        }
    }

    //입력값을 Separator 로 보내고 최종 결과 반환
    int calculate(String input) {
        if (!validateInput(input)) {
            return 0;
        }
        String numbers = separator.extractNumbers(input);
        return adder.addAll(numbers);
    }

    //결과 출력
    void printResult(int result) {
        System.out.println("결과 : " + result);
    }

    public void run() {
        String input = getInput();
        int result = calculate(input);
        printResult(result);
    }
}
