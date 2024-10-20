package calculator;

import java.util.Scanner;

public class Application {
    public static int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String[] nums = numbers.split("[,:]");
        int sum = 0;

        for (String num : nums) {
            sum += Integer.parseInt(num.trim());
        }

        return sum;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner sc = new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = sc.nextLine();
        int result = add(input);
        System.out.println("결과 : " + result);
    }
}
