package calculator.util;

public class ArrayConverter {

    public int[] convertCharArrayToIntArray(char[] positiveCharArray) {
        return new String(positiveCharArray)
                .chars()
                .map(Character::getNumericValue)
                .toArray();
    }
}
