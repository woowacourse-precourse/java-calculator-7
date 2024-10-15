package calculator;

import java.util.Scanner;

public class Application {
    // 01. 사용자 입력 기능
    private static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("덧셈할 문자열을 입력해 주세요.\n");
        String input = scanner.nextLine().trim();

        // null 또는 비어있는 문자열 처리
        if (input.isEmpty()) {
            System.out.println("결과 : 0");
            return ""; // 빈 문자열 반환
        }

        return input; // 유효한 입력 반환
    }

    public static void main(String[] args) {
        String input = getUserInput();
    }
}
