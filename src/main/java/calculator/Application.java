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
    }
}
