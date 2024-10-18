package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        // 기본(쉼표, 콜론) 구분자로 각 숫자의 합을 반환하는 기능
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        // 빈 문자열 처리
        if (str.equals("")) {
            System.out.println("0");
            return;
        }

        // 커스텀 구분자 처리
        String customDelimiter = ",|:";
        if (str.startsWith("//")) {
            int delimiterIndex = str.indexOf("\n");
            customDelimiter = str.substring(2, delimiterIndex);
            str = str.substring(delimiterIndex + 1);
        }

        // 커스텀 문자 또는 기본 구분자로 분리
        String[] numbers = str.split(customDelimiter);

        try {
            int sum = 0;
            for (String number : numbers) {
                sum += Integer.parseInt(number);
            }
            System.out.println("결과 : " + sum);
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }
    }
}
