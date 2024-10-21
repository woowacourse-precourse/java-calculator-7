package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.InputMismatchException;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        try {
            StringCalculator calculator = new StringCalculator();
            int result = calculator.add(input);
            System.out.println("결과 : " + result);
        } catch (InputMismatchException e) {
            System.out.println("에러 : " + e.getMessage());
        }
    }
}

class StringCalculator {
    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:";

        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\\n");
            if (delimiterIndex != -1) {
                delimiter = input.substring(2, delimiterIndex);
                input = input.substring(delimiterIndex + 2);
            } else {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        }

        String[] tokens = input.split(delimiter);

        int sum = 0;
        System.out.println("delimiter : " + delimiter + "token : " + Arrays.toString(tokens));
        for(String token : tokens) {
            try {
                int number = Integer.parseInt(token);
                if(number < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않습니다.");
                }
                sum += number;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 숫자 형식입니다.");
            }
        }
        return sum;
    }
}