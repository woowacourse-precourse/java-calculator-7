package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = sc.nextLine();

        // 예외처리
        try{
            System.out.println("결과 : " + sum(input));

        }catch (IllegalArgumentException e){
            return;
        }
    }

    public static int sum(String input) {

        String base = "[,:]";

        // 커스텀 구분자가 있는지 확인
        int customStart = input.indexOf("//");
        if (customStart == 0) {
            int customLast = input.indexOf("\\n");
            // 구분자가 없는 경우
            if (customLast == -1) {
                throw new IllegalArgumentException();
            }
//            System.out.println(customLast);
            base = String.valueOf(input.charAt(customStart + 2));
//            System.out.println(base);
            input = input.substring(customLast + 2);
//            System.out.println(input);
        }

        String[] nums = input.split(base);

        int total = 0;
        for (String n : nums) {
            if (!n.isEmpty()) {
                int num = Integer.parseInt(n);
                // 숫자가 음수인경우
                if (num < 0) {
                    throw new IllegalArgumentException();
                }
                total += num;
            }
        }
        return total;
    }
}
