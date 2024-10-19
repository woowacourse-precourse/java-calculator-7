package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        String input = getInput();

        int result = processInput(input);

        printOutput(result);
    }

    private static String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    private static int processInput(String input) {
        return 0;
    }


    private static void printOutput(int result) {
    }

}
