package calculator;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("덧셈할 문자열을 입력해주세요: ");
        
        try {
            String input = sc.nextLine();
            sc.close();
            
            int sum = calculateSum(input);
            System.out.println("결과 : " + sum);
        } catch (IllegalArgumentException e) {
            System.out.println("에러: " + e.getMessage());
        }
    }

    private static int calculateSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:";
        if (input.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.)\\n(.*)").matcher(input);
            if (matcher.find()) {
                delimiter = matcher.group(1);
                input = matcher.group(2);
            } else {
                throw new IllegalArgumentException("잘못된 구분자 형식입니다.");
            }
        }

        String[] numbers = input.split(delimiter);
        int sum = 0;

        for (String number : numbers) {
            int num = toPositiveNumber(number);
            sum += num;
        }

        return sum;
    }

    private static int toPositiveNumber(String number) {
        int result;
        try {
            result = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 형식이 올바르지 않습니다.");
        }

        if (result < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다.");
        }

        return result;
    }
}
