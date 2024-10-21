package calculator;
import java.util.List;
import java.util.Objects;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        try {
            List<Double> numbers = Parser.parse(input);

            double sum = numbers.stream()
                            .filter(Objects::nonNull)
                                    .reduce(0.0, Double::sum);

            if (Double.isInfinite(sum)) {
                throw new IllegalArgumentException("합산 결과가 너무 커서 Infinity가 발생했습니다.");
            }

            if (sum == (int)sum)
                System.out.println("결과 : " + (int)sum);
            else
                System.out.println("결과 : " + sum);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
