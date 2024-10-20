package calculator;

import static calculator.Constants.*;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigInteger;

public class UserInteractionManager {
    public String readInput() {
        System.out.println(PROMPT_MESSAGE);
        return Console.readLine();
    }

    public void printOutput(BigInteger result) {
        System.out.print(OUTPUT_MESSAGE + result);
    }
}
