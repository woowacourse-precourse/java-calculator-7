package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = sc.nextLine();

        int result = calc(input);
        System.out.println("결과 : " + result);

        sc.close();
    }

    public static int calc(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        int result = 0;
        String[] numbers = input.split("[,:]");

        for (String num : numbers) {
            result += Integer.parseInt(num.trim());
        }
        return result;
    }
}
