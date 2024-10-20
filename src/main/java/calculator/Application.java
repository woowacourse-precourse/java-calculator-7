package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String line = Console.readLine();

        String[] nums;
        int sum = 0;
        String delimiter = ",|:";

        // 커스텀 구분자
        if (line.startsWith("//")) {
            nums = line.split("\\\\n", 2);
            if (nums.length == 1) {
                throw new IllegalArgumentException("Invalid custom delimiter format");
            } else {
                delimiter += "|" + nums[0].substring(2);
                line = nums[1];
            }
        }

        // 구분자를 기준으로 분리
        nums = line.split(delimiter);

        for (String num : nums) {
            if (num.isEmpty()) {
                continue;
            }
            try {
                sum += Integer.parseInt(num);
                if (Integer.parseInt(num) < 0) {
                    throw new IllegalArgumentException("Negative number");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid number format");
            }
        }

        System.out.println("결과 : " + sum);
    }
}
