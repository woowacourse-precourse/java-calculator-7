package calculator;

import java.util.Scanner;

public class Application {

    // 문자열이 비어있을 경우 0을 반환한다.
    int add(String text) {
        if (text.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\n";

        // 커스텀 구분자 처리
        if (text.startsWith("//")) {
            int delimiterIndex = text.indexOf("\n");
            if (delimiterIndex == -2) {
                throw new IllegalArgumentException("Invalid input: " + text);
            }

            delimiter = text.substring(2, delimiterIndex); // 커스텀 구분자 추출
            text = text.substring(delimiterIndex + 1); // 숫자 부분 추출
        }

        // 구분자에 맞춰 숫자 분리
        String[] numbers = text.split(delimiter);
        int[] values = toInt(numbers);
        return sum(values);
    }

    int[] toInt(String[] numbers) {
        int[] values = new int[numbers.length];
        for(int i=0; i < numbers.length; i++) {
            try {
                values[i] = Integer.parseInt(numbers[i].trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid input: " + numbers[i]);
            }
        }
        return values;
    }

    int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            if (number < 0) {
                throw new IllegalArgumentException("Negative numbers are not allowed: " + number);
            }
            sum += number;
        }
        return sum;
    }

    public static void main(String[] args) {
       Application app = new Application();
       System.out.println("덧셈할 문자열을 입력해 주세요.");
       Scanner sc = new Scanner(System.in);
       String input = sc.nextLine();
       int result = app.add(input);
       System.out.println("결과 : " + result);
      }
}
