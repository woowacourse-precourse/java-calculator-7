package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Calculator calculator = new Calculator(Arrays.asList(",", ":"));
        String input;

        input = inputString();

        int result = calculator.run(input);

        outputResult(result);
    }

    // 문자열 입력
    public static String inputString() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    // 결과 반환
    public static void outputResult(int result) {
        System.out.println("결과 : " + result);
    }
}
