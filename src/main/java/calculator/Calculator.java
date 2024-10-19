package calculator;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Calculator {
    Scanner scanner;
    String input;
    String separator;
    StringTokenizer operandList;

    Calculator() {
        scanner = new Scanner(System.in);
        separator = "";
        operandList = null;
    }

    public void run() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        input = scanner.nextLine();

        //입력 값이 없으면 결과 값은 0
        if (input.equals("")) {
            System.out.println(0);
            return;
        }

        if (checkCustom()) {
            separator = separator + input.charAt(2);
            input = input.substring(5);
        }
        operandList = new StringTokenizer(input, separator);

        while (operandList.hasMoreTokens()) {
            System.out.print(operandList.nextToken() + " ");
        }
    }

    //커스텀 구분자가 둘 다 있는지 확인하기
    private boolean checkCustom() {
        if (input.substring(0, 2).equals("//")) {
            if (input.charAt(3) == '\\' && input.charAt(4) == 'n') {
                return true;
            } else {
                throw new IllegalArgumentException();
            }
        }
        return false;
    }
}
