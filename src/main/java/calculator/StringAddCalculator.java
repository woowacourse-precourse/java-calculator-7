package calculator;

import calculator.Util.Parser;
import calculator.Util.Validator;
import java.util.List;

//문자열을 받아 계산하는 로직 담당
public class StringAddCalculator {
    public static int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;  // 빈 문자열일 경우 0 반환
        }

        //숫자 검증
        Validator.validateInput(input);

        List<Integer> numbers;
        if (input.startsWith("//")) {
            numbers = Parser.parseWithCustomDelimeter(input);
        } else {
            numbers = Parser.parseWithDefaultDelimeter(input);
        }

        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}
