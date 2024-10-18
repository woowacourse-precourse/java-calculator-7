package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);

        // 전체 입력을 받기 위해 nextLine() 사용
        String susik = sc.nextLine();

        if (susik == null || susik.trim().isEmpty()) {
            System.out.println("결과 : " + 0);
        }
    }
}
