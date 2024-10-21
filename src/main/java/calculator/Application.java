package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void calculate(String input) {
        String numbers;
            numbers = input;
            // 쉼표와 콜론을 기준으로 분리
            String[] numberArray = numbers.split("[,;]");
        return;
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            System.out.println("숫자를 입력하세요");
            String input = Console.readLine();
            calculate(input);
        }
        finally {
            Console.close();
        }
    }
}