package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int sum = 0;
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String msg = Console.readLine();
        if (!msg.equals("")) {
            String[] numbers = msg.split(":|,");
            try {
                System.out.println(numbers[0]);
                for (String number : numbers) {
                    int temp = Integer.parseInt(number);
                    if (temp > 0) {
                        sum += temp;
                    } else {
                        throw new Exception();
                    }
                }
            } catch (Exception e) {
                throw new IllegalArgumentException();
            }
        }
        System.out.println("결과 : " + sum);
    }
}
