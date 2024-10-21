package calculator;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        System.out.print("숫자를 입력하세요: ");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        try {
            System.out.println("결과 : " + add(input));
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 값을 입력하였습니다.: " + e.getMessage());
        }

        scanner.close();  // Scanner 닫기
    }

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:"; // 기본 구분자: 쉼표와 콜론

        // 커스텀 구분자 처리
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\\n");
            if (delimiterIndex == -1) {
                throw new IllegalArgumentException("커스텀 구분자 지정 오류");
            }
            delimiter = input.substring(2, delimiterIndex);
            input = input.substring(delimiterIndex + 2);
     }

        String[] numbers = input.split(delimiter); // 구분자를 기준으로 숫자 분리

        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number); // 각 숫자를 정수로 변환하여 더함
        }

        return sum;
    }
}
