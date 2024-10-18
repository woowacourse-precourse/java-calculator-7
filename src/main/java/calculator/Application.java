package calculator;

import java.util.Scanner;
public class Application {
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = "";
        if (scanner.hasNextLine()) { // 입력 문자열이 null이 아니라면, 버퍼로부터 입력값을 가져온다.
            input = scanner.nextLine();
        }
    }
}
