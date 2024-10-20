package calculator;
import java.util.List;

public class Calculator {

    private final Parser parser = new Parser();

    /**
     * 입력된 문자열의 숫자들을 모두 더하고, 합계가 정수라면 long, 소수라면 double로 반환합니다.
     * @param input 입력 문자열
     * @return 합계가 정수인 경우 long, 아닌 경우 double로 반환
     */
    public Number calculate(String input) {
        // 입력 문자열을 파싱하여 숫자 리스트를 얻음
        List<Double> numbers = parser.parseInput(input);

        // 숫자들의 합을 구함
        double sum = numbers.stream().mapToDouble(Double::doubleValue).sum();

        // 합계가 정수로 캐스팅 가능한지 확인
        if (sum == (long) sum) {
            // 정수로 캐스팅 가능하면 long으로 반환
            return (long) sum;
        } else {
            // 그렇지 않으면 double로 반환
            return sum;
        }
    }
}
