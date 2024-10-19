package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("덧셈할 문자열을 입력해 주세요.\n");
        String input = scanner.nextLine();
        Integer sum = 0;

        if (input.startsWith("//")) {
            // 커스텀 문자열 사용
        }
        else {
            // 커스텀 문자열 미사용
            String[] parsedInput = input.split(",|:");

            for (String s : parsedInput) {
                sum += Integer.parseInt(s);
            }
        }
        System.out.println("결과 : " + sum);
    }
}