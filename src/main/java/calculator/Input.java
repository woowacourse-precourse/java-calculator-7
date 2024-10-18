package calculator;

import java.util.Scanner;

public class Input {
    private Scanner scanner;


    public String getUserInput() {
        this.scanner = new Scanner(System.in);  // Scanner 객체 초기화
        System.out.println("덧셈할 문자열을 입력해 주세요.: ");  // 사용자에게 입력 요청 메시지 출력
        String string = scanner.nextLine();  // 사용자로부터 한 줄의 문자열 입력 받기
        System.out.println(string);
        return string;
    }

    public void closeScanner() {
        scanner.close();  // Scanner 객체 닫기
    }
}
