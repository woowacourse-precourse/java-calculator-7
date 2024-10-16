package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner sc = new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = sc.nextLine();

        try {
            int result = calculate(input);
            System.out.println("결과 : " + result);
        }
        catch (IllegalArgumentException e){
            System.out.println("잘못된 입력입니다." + e.getMessage());
        }
    }
    // 입력받은 문자열로 덧셈을 수행하는 메소드
    public static int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|;"; // 구분자
        String numbers = input; // 아직은 input이 문자열 타입이다.


        String[] tokens = numbers.split(delimiter);
        int sum = 0;

        for (String token : tokens) {
            int number = Integer.parseInt(token); // 양수로 변환해주기

            sum += number;
        }
        return sum;
    }
}
