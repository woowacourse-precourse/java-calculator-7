package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        try {
            String input = Input.readString();
        } finally {
            Console.close();
        }
    }
}
