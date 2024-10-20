package calculator;

import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) {
        int sum = 0;
        String[] nums;
        String separator = ",|:";

        System.out.println("덧셈할 문자열을 입력해주세요.");

        String string = Console.readLine();
        if (string.startsWith("//")) {
            nums = string.split("\\\\n", 2);
            String newSep=nums[0].replace("//", "");
            separator += "|" + newSep;
            string = nums[1];
        }

        nums = string.split(separator);
        for (String num : nums) {
            if (num.isEmpty()) {
                continue;
            }
            try {
                sum += Integer.parseInt(num);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 입력 값");
            }
        }

        System.out.println("결과 : " + sum);
    }

}
