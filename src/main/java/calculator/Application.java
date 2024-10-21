package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringCalculator calculator = new StringCalculator();

        System.out.println("덧셈할 문자열을 입력해주세요: ");
        String input = sc.nextLine();

        try{
            int result = calculator.calculate(input);
            System.out.println("결과: " + result);
        } catch (IllegalArgumentException e){
            System.out.println("오류: " + e.getMessage());
        }

        sc.close();
    }

    class StringCalculator {
        public int calculate(String input) {
            return 0;
        }
    }
}