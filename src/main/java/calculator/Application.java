package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

//        입력받기.
        String input = getInput();
    }

    public static String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요. ");
        return Console.readLine();
    }
    }
}
