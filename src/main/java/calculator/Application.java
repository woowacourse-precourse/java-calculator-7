package calculator;

import camp.nextstep.edu.missionutils.Console;

import static java.lang.Integer.parseInt;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = Console.readLine();
            int result = calc(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int calc(String input) {
        if (input == null) {
            return 0;
        }

        String deli= ",|:";
        if (input.startsWith("//")) {
            deli =  input.substring(2);
            if (deli.length() == 0) throw new IllegalArgumentException("커스텀 구분자를 지정하지 않았습니다.");
            String numInput = Console.readLine();
            String[] nums = numInput.split(deli);
            int total = 0;
            for (String num : nums) {
                total += IsNumber(num);
            }
            return total;
        }

        String[] nums = input.split(deli);
        int total = 0;

        for (String num : nums) {
            total += IsNumber(num);
        }

        return total;
    }

    private static int IsNumber(String num) {
        int n;
        try {
            n = parseInt(num);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
        return n;
    }
}
