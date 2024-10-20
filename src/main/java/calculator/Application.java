package calculator;

import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) {
        int sum = 0;

        String string = Console.readLine();
        String[] nums = string.split(",|:");
        for (String num : nums) {
            sum += Integer.parseInt(num);
        }

        System.out.println("sum = " + sum);
    }
}
