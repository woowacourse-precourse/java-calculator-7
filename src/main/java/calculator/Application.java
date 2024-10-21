package calculator;

import java.util.Scanner;
import java.util.stream.Stream;
import java.util.regex.Pattern;

public class Application {
    private int answer = 0;

    public static void main(String[] args) {
        System.out.println(new Application().calculator());
    }

    public String calculator() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = scanner.nextLine();

        scanner.close();
        return "결과 : " + answer;
    }
}