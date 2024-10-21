package calculator;

public class StringParser {

    static void isMinusNumberUsed(String[] numbers) {
        for (String number : numbers) {
            if (number.contains("-")) {
                throw new IllegalArgumentException();
            }
        }
    }
}
