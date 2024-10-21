package calculator;

import static calculator.Constants.SINGLE_ELEMENT;
import static calculator.Constants.START_INDEX;

public class EmptyInputHandler {
    public boolean isEmptyString(String[] seperatedNumbers) {
        return seperatedNumbers.length == SINGLE_ELEMENT && seperatedNumbers[START_INDEX].isEmpty();
    }
}
