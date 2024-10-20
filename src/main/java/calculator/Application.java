package calculator;

import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) {
        int sum = 0;
        String[] nums;
        String separator = ",|:";

        String string = Console.readLine();
        if (string.startsWith("//")) {
            nums = string.split("\\\\n", 2);
            String newSep=nums[0].replace("//", "");
            separator += "|" + newSep;
            string = nums[1];
        }

        nums = string.split(separator);
        for (String num : nums) {
            sum += Integer.parseInt(num);
        }

        System.out.println("sum = " + sum);
    }

}
