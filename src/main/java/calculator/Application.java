package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    static int calculator(String in) {
        int sum = 0;
        String[] nums = in.split(",|:");

        for (String num : nums) {
            sum += Integer.parseInt(num);
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println("덧샘할 문자열을 입력해 주세요.");
        String s = Console.readLine();
        int result = calculator(s);
        System.out.println("결과 : " + result);
    }
}
