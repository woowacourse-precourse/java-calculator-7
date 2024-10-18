package calculator;

import calculator.processor.Calculator;
import calculator.processor.StringCalculator;
import camp.nextstep.edu.missionutils.Console;
import java.util.Optional;

public class Application
{
    public static void main(String[] args)
    {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        System.out.println(input);
        Calculator cal = new StringCalculator(input);
        Console.close();

        Optional<Integer> result = cal.calculate();
        result.orElseThrow(IllegalArgumentException::new);
        System.out.println("결과 : " + result.get());
    }
}
