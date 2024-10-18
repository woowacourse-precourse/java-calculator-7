package calculator.console;

import calculator.domain.Adder;
import calculator.domain.Separator;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorConsole {

    private String input;
    private Separator separator;
    private Adder adder;

    public CalculatorConsole(Separator separator, Adder adder) {
        this.separator = separator;
        this.adder = adder;
    }

    // 사용자로부터 문자를 입력받음
    String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        input = Console.readLine();

        // null 입력인 경우 예외 처리
        if (input == null) {
            throw new IllegalArgumentException("입력값이 null입니다.");
        }

        System.out.println(input);
        return input;
    }

    // 입력값을 Separator 로 보내고 최종 결과 반환
    int calculate(String input) {
        String numbers = separator.extractNumbers(input);
        return adder.addAll(numbers);
    }

    // 결과 출력
    void printResult(int result) {
        System.out.println("결과 : " + result);
    }

    public void run() {
        String input = getInput();
        int result = calculate(input);
        printResult(result);
    }
}