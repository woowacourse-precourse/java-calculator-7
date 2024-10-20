package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static int add(String input) {
        String delimiter = "";
        String[] numbers;
        int sum = 0;
        if(input == null || input.isEmpty() || input.isBlank()) {
            return 0;
        } else {
            return sum;
        }
    }
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
    }
}
