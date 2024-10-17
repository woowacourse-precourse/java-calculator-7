package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static ArrayList<String> seperatorList = new ArrayList<>(List.of(".", ":"));
    public static String userInput;

    public static void getCustomSeperator(String input) {
        String customSeperator;
        if (input.contains("\\n") && input.contains("//")) {
            customSeperator = input.substring(input.indexOf("//") + 2, input.indexOf("\\n"));
            if (customSeperator.length() > 1) {
                throw new IllegalArgumentException("한개의 커스텀 구분자만 추가할 수 있습니다.");
            }
            if (input.indexOf("//") != 0) {
                throw new IllegalArgumentException("커스텀 구분자는 문자열 처음에서만 추가할 수 있습니다.");
            }
            seperatorList.add(customSeperator);
            userInput = userInput.substring((input.indexOf("\\n") + 2));
        }
    }

    public static String getUserInput() {
        String userInput;
        Scanner scanner = new Scanner(System.in);
        userInput = scanner.nextLine();
        System.out.println(userInput);
        return userInput;
    }

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해주세요");
        userInput = getUserInput();
        getCustomSeperator(userInput);
        System.out.println(seperatorList);
    }
}
