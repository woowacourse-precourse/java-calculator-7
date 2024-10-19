package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        String UserInput = valueInput();

        if (UserInput.isEmpty()) {
            System.out.println("결과 : 0");
            return;
        }

        if (hasPattern(UserInput)) {

        } else {

        }
    }


    static String valueInput() {
        try {
            return Console.readLine();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    static boolean hasPattern(String input) {
        try {
            String checkMobile = input.substring(0, 5);
            return checkMobile.contains("//");
        } catch (StringIndexOutOfBoundsException e) {
            return false;
        }
    }
}
