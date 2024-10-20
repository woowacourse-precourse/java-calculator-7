package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class Application {
    static int calculator(String in) {
        if (in == null || in.trim().isEmpty()) {
            return 0;
        }
        int sum = 0;
        String[] nums = in.split(",|:");
        if (in.startsWith("//")) {
            in = in.replaceFirst("//", "").replace("\\n", "\n");
            String[] temp = in.split("\n", 2);
            String customDelimiter = temp[0];
            in = temp[1];

            nums = in.split(customDelimiter);
        }
        for (String num : nums) {
            sum += Integer.parseInt(num);
        }
        return sum;
    }
    public static void main(String[] args) {
        try {
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String s = Console.readLine();
            int result = calculator(s);
            System.out.println("결과 : " + result);
        } catch (NoSuchElementException e) {
            System.out.println("결과 : 0");
        }
    }
}
