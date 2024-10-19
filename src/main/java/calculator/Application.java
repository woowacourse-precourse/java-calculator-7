package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String userInput = Console.readLine();

        long sum = 0;
        if (userInput.contains(",") || userInput.contains(":")) {
            if (userInput.contains(",")) {
                String[] nums = userInput.split(",");
                for (String num : nums) {
                    String[] splits = num.split(":");
                    for (String split : splits) {
                        sum += Long.parseLong(split);
                    }
                }
            }
        }
        System.out.println("결과 : " + sum);
        Console.close();

    }
}
