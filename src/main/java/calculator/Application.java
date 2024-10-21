package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = Console.readLine();

    }
    private static boolean check_delimeter(String input) {
        if(input.charAt(0)=='/' && input.charAt(1)=='/') {
            return true;
        }
        return false;
    }
}

