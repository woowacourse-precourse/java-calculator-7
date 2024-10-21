package calculator;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = scanner.nextLine();
        scanner.close();

        if (input.isEmpty()) {
            System.out.println("결과 : 0");
            return;
        }

        String delimiter = ",|:";
        String numbers = input;

        if (input.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.*)\n(.*)").matcher(input);
            if (matcher.find()) {
                delimiter = Pattern.quote(matcher.group(1));
                numbers = matcher.group(2);
            }
        }

        String[] nums = numbers.split(delimiter);
        int sum = 0;

        try {
            for (String num : nums) {
                int n = Integer.parseInt(num.trim());
                if (n < 0) {
                    System.out.println("오류: 음수는 허용되지 않습니다: " + n);
                    return;
                }
                sum += n;
            }
            System.out.println("결과 : " + sum);
        } catch (NumberFormatException e) {
            System.out.println("오류: 올바른 숫자 형식이 아닙니다.");
        }

    }
}
