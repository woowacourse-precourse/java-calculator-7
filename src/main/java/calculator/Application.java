package calculator;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringCalculator calculator = new StringCalculator();

        System.out.println("덧셈할 문자열을 입력해주세요: ");
        String input = sc.nextLine();

        try {
            int result = calculator.calculate(input);
            System.out.println("결과: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("오류: " + e.getMessage());
        }

        sc.close();
    }

    static class StringCalculator {
        public int calculate(String input) {
            if (input.isEmpty()) {
                return 0;
            }

            String delimiter = "[,:]";
            String numberString = input;

            if (input.startsWith("//")) {
                int delimiterIndex = input.indexOf("\\n");
                if (delimiterIndex != -1) {
                    delimiter = Pattern.quote(input.substring(2, delimiterIndex));
                    numberString = input.substring(delimiterIndex + 2);
                } else {
                    throw new IllegalArgumentException("커스텀 구분자 형식에 오류가 있습니다.");
                }
            }

            String[] numbers = numberString.split(delimiter);
            int sum = 0;
            for(String number : numbers) {
                try {
                    int num = Integer.parseInt(number);
                    if(num < 0){
                        throw new IllegalArgumentException("음수는 허용되지 않습니다." + num);
                    }
                    sum += num;
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("숫자 형식에 오류가 있습니다:" + number);
                }
            }
            return sum;
        }
    }
}
