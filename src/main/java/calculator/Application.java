package calculator;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("덧셈할 문자열을 입력해 주세요.\n");
        String input = scanner.nextLine();
        double result;

        if (input.startsWith("//")) {
            // 커스텀 문자열 사용
            String [] customInfo = input.split("\\\\n", 2);
            String customString = Pattern.quote(customInfo[0].substring(2));
            Calculator calculator = new Calculator(customString);
            String[] parsedInput = calculator.parseString(customInfo[1]);
            result = calculator.calculate(parsedInput);
        }
        else {
            // 커스텀 문자열 미사용
            Calculator calculator = new Calculator();
            String[] parsedInput = calculator.parseString(input);
            result = calculator.calculate(parsedInput);
        }

        if (result == (long) result) {
            System.out.println("결과 : " + (long) result);
        } else {
            System.out.println("결과 : " + result);
        }
    }
}