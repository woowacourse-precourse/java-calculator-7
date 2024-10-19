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
                        if (Long.parseLong(split) < 0) {
                            throw new IllegalArgumentException("구분자와 양수로 구성된 문자열을 입력해 주세요.");
                        }
                        sum += Long.parseLong(split);
                    }
                }
            }
        } else if (userInput.contains("//") && userInput.contains("\\n")) {
            String separator = userInput.substring(userInput.indexOf("//") + 2,
                userInput.indexOf("\\n"));
            String[] nums = userInput.substring(userInput.indexOf("\\n") + 2).split(separator);
            for (String num : nums) {
                if (Long.parseLong(num) < 0) {
                    throw new IllegalArgumentException("구분자와 양수로 구성된 문자열을 입력해 주세요.");
                }
                sum += Long.parseLong(num);
            }
        } else {
            throw new IllegalArgumentException("구분자와 양수로 구성된 문자열을 입력해 주세요.");
        }

        System.out.println("결과 : " + sum);
        Console.close();

    }
}
