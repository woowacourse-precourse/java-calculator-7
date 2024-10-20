package calculator.model;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public String readInput() {
        return Console.readLine().trim().replace("\\n", "\n");
    }
}
