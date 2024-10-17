package calculator;

import java.util.Arrays;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        var text = readLine();
        var regex = ",|:";
        String[] nums;
        if (text.indexOf("//") != -1) {
            if (text.indexOf("\\n") == -1) {
                throw new IllegalArgumentException();
            }
            var custom = text.substring(2, text.indexOf("\\n"));
            if (!custom.equals("")) {
                regex += "|" + custom;
            }
            nums = text.substring(text.indexOf("\\n") + 2, text.length()).split(regex);
        } else {
            nums = text.split(regex);
        }

        System.out.println(Arrays.toString(nums));

        var total = 0;
        for (String num_text : nums) {
            int num;
            try {
                num = Integer.parseInt(num_text);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
            if (num < 0) {
                throw new IllegalArgumentException();
            }
            total += num;
        }
        System.out.println("결과 : " + total);
    }
}
