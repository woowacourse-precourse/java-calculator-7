package calculator;

public class NumberValidator {
    void NegativeOrZeroCheck(String[] delimitedNumbers) {
        for (String delimitedNumber : delimitedNumbers) {
            if (delimitedNumber.contains("-") || delimitedNumber.equals("0")) {
                throw new IllegalArgumentException();
            }
        }
    }


}
