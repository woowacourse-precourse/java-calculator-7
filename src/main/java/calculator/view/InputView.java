package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String read() {
        String input;
        try {
            input = Console.readLine();
        } finally {
            Console.close();
        }
        return input;
    }

}
