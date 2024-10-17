package calculator;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int result = calculate(input);
        System.out.println("결과 : " + result);
    }
    public static int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:"; // 기본 구분자
        String numbers = input;

        // 커스텀 구분자가 있을 경우 이를 처리
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\n");

            // "\n"이 없다면 잘못된 입력 형식으로 판단하지 않고 그대로 반환
            if (delimiterIndex == -1) {
                return 0;
            }

            delimiter = input.substring(2, delimiterIndex); // 커스텀 구분자를 추출
            numbers = input.substring(delimiterIndex + 1); // 숫자 부분만 추출
        }

        // 정규식을 사용하여 커스텀 구분자 또는 기본 구분자로 숫자 분리
        String[] tokens = numbers.split(delimiter);
        int sum = 0;

        for (String token : tokens) {
            if (!token.isEmpty()) {
                int number = Integer.parseInt(token);
                if (number < 0) {
                    throw new IllegalArgumentException("Negative numbers not allowed");
                }
                sum += number;
            }
        }
        return sum;
    }



}
