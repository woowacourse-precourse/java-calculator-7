package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = Input.inputString();
    }
}

class Input {
    public static String inputString() {
        System.out.println("Please enter the strings to add.");
        return Console.readLine();
    }
}
