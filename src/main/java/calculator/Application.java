package calculator;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 문자열 입력
        System.out.print("덧셈할 문자열을 입력해주세요.");
        String input = scanner.nextLine();

        // 결과 출력
        int result = StringCalculator.add(input);
        System.out.println("결과 : " + result);

        scanner.close();
    }
}

class StringCalculator {
    public static int add(String input) {

        // 쉼표(,)와 콜론(:)을 기준으로 문자열을 분리
        String[] numbers = input.split("[,:]");

        // 각 숫자를 합산
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number.trim());
        }
        return sum;
    }
}