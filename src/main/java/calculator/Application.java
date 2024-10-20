package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        // Parser를 사용해 숫자를 추출
        Parser parser = new Parser();
        List<Integer> numbers = parser.parse(input);

        // Calculator를 사용해 숫자의 합 계산
        Calculator calculator = new Calculator();
        int result = calculator.sum(numbers);

        System.out.println("결과 : " + result);
    }
}
