package calculator;

import calculator.util.MyCalculator;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner scanner = new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요. ");
        String expression = scanner.nextLine();
        
        MyCalculator calculator = new MyCalculator();
        
        
        int result = calculator.calculate(expression);
        System.out.printf("결과 : %d", result);
    }
}
