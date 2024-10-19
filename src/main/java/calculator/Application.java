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
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        int result = add(input);
        System.out.println(result);
    }
}
