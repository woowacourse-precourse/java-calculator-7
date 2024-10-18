package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        String UserInput = ValueInput();
        
    }


    static String ValueInput() {
        try {
            return Console.readLine();
        } catch (NoSuchElementException e) {
            return "";
        }
    }
}