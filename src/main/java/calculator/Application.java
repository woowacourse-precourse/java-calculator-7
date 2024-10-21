package calculator;
import java.util.List;
import java.util.Objects;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        List<Long> numbers = Parser.parse(input);

        long sum = 0L;
        for (Long number : numbers) {
            if (number != null) {
                if (sum > Long.MAX_VALUE - number)
                    throw new IllegalArgumentException("합산 결과가 너무 커서 오버플로우가 발생했습니다.");
                sum += number;
            }
        }

        System.out.println("결과 : " + sum);
    }
}
