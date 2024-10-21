package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner scan = new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = scan.nextLine();

        int result = 0;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == ',' || ch == ':') {
                continue;
            } else if (Character.isDigit(ch)) {
                result += Character.getNumericValue(ch);
            }

        }

        System.out.println("결과 : " + result);

        scan.close();
    }
}
