package calculator;

import java.util.Scanner;

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

        String[] numbers = input.split(delimiter);

        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }

        return sum;

    }
}
