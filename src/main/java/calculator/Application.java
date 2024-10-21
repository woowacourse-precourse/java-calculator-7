package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int result = 0;

        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String str = Console.readLine();
        if (str.equals("")) {
            System.out.println("결과 : 0");
        } else {
            String[] numbers = str.split(",|:");
            for (String s : numbers) {
                int num = Integer.parseInt(s);
                if (num < 0) {
                    throw new IllegalArgumentException();
                }
                result += Integer.parseInt(s);
            }
            System.out.println("결과 : " + result);
        }

    }
}
