package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = sc.nextLine();

        System.out.println("결과 : " + sum(input));
    }

    public static int sum(String input) {
        String[] nums = input.split("[,:]");

        int total = 0;
        for (String n : nums) {
            if (!n.isEmpty()) {
                int num = Integer.parseInt(n);
                total += num;
            }
        }
        return total;
    }
}
