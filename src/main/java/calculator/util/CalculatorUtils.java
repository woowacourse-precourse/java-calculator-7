package calculator.util;

import java.util.Scanner;

public class CalculatorUtils {

    public static String getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return scanner.nextLine();
    }
}
