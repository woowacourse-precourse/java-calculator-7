package calculator;
import java.util.Scanner;
public class Application {
    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator();
        Scanner scanner = new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = scanner.nextLine();
        try {
            int result = calculator.inputString(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.err.println("잘못된 입력: " + e.getMessage());
        }
    }
}