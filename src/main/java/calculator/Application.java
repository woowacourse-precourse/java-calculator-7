package calculator;

import calculator.calc.Calc;
import calculator.parser.DelimiterParser;
import calculator.parser.NumberParser;
import calculator.valid.Validation;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.print("덧셈할 문자열을 입력해 주세요 : ");

        String input = Console.readLine();

        System.out.println("결과 : " + run(input));
    }

    public static int run(String input) {

        //TODO 1 : 입력 문자열이 빈 문자열일 경우 0을 반환
        if (input.isEmpty()) {
            return 0;
        }

        // 구분자 추출
        List<String> formatter = DelimiterParser.parseDelimiters(input);

        // 숫자 추출
        List<Integer> numberFormatter = NumberParser.parseNumbers(input, formatter);

        // 유효성 검사
        Validation.validation(numberFormatter);

        return Calc.sum(numberFormatter);
    }
}
