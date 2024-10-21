package calculator;

import java.util.*;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            String input = scanner.nextLine();
            String[] splitInput;
            int answer = 0;

            if (input.startsWith("//")) {
                String[] parts = input.split("\n", 2);
                String custom = parts[0].substring(2);
                splitInput = parts[1].split(Pattern.quote(custom)); // 커스텀 구분자를 정규식으로 처리
            } else {
                splitInput = input.split("[,:]");
            }

            for (String number : splitInput) {
                if (number.trim().isEmpty()) {
                    continue; // 빈 문자열은 건너뜁니다.
                }
                int num = Integer.parseInt(number.trim());
                if (num < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않습니다: " + num);
                }
                answer += num;
            }

            System.out.println("결과: " + answer);

        } catch (NumberFormatException e) {
            System.out.println("잘못된 입력: 숫자만 입력해주세요.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}