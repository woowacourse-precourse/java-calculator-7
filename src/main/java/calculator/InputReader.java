package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.NoSuchElementException;

public class InputReader {

    public String readInput() {
        try {
            return readLine();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

}
