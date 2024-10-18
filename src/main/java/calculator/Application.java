package calculator;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int result = 0;

        if (input.startsWith("//")) {
            String delimiter = input.substring(2, input.indexOf("\\n"));
            String[] numbers = input.substring(input.indexOf("\\n") + 2).split(",|:|" + delimiter);
            result = sumNumbers(numbers);
        } else {
            String[] numbers = input.split(",|:");
            result = sumNumbers(numbers);
        }

        System.out.println("결과 : " + result);
    }

    private static int sumNumbers(String[] numbers) {
        int result = 0;
        for (String num : numbers) {
            int number = Integer.parseInt(num.trim());
            if (number < 0) {
                throw new IllegalArgumentException("잘못된 값입니다: " + number);
            }
            result += number;
        }
        return result;
    }
}
