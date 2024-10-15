package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class View {

    public static String input() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public static void output(Double sum) {
        if (sum % 1 == 0) { // 총합이 정수인 경우
            System.out.printf("결과 : %d\n", (int)Math.floor(sum));
        } else {
            System.out.printf("결과 : %f\n", sum);
        }
    }
}
