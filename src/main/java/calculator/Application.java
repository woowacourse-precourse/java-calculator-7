package calculator;

import java.util.Scanner;

import static calculator.CalculatorFunctions.addToken;
import static calculator.CalculatorFunctions.splitAndSum;

public class Application {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        // 각 숫자의 합을 구하기
        int result = splitAndSum(str);

        System.out.println("결과 : " + result);
    }



}
