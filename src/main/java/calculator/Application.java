package calculator;

import java.util.Scanner;

public class Application {


    public static String getCustomSeperator(String input) {
        String customSeperator = "";
        System.out.println("input:" + input);
        if (input.contains("\\n") && input.contains("//")) {
            customSeperator = input.substring(input.indexOf("//") + 2, input.indexOf("\\n"));
        }
        return customSeperator;
    }

    public static String getUserInput() {
        String userInput;
        Scanner scanner = new Scanner(System.in);
        userInput = scanner.nextLine();
        System.out.println(userInput);
        return userInput;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해주세요");
        getCustomSeperator(getUserInput());
    }
}
