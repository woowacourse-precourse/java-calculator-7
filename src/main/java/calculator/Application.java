package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String input = Console.readLine();
        int sum = 0;

        for (byte value : input.getBytes()) {
            if (value >= '0' && value <= '9') {
                sum += value - '0';
            } else if (value != ',' && value != ':') {
                throw new IllegalArgumentException();
            }
        }

        System.out.println("결과 : " + sum);

        Console.close();
    }
}
