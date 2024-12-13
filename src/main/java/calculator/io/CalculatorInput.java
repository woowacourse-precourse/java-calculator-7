package calculator.io;

import calculator.domain.Strings;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorInput {

    public CalculatorInput() {
    }

    public Strings getString() {
        String input = Console.readLine();

        return new Strings(input);
    }


}
