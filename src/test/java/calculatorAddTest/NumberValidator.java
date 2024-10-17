package calculatorAddTest;

public class NumberValidator {
    void positiveNumberCheck(String[] delimitedNumbers) {
        for (String delimitedNumber : delimitedNumbers) {
            if (!delimitedNumber.matches("^[1-9]\\d*$")) {
                throw new IllegalArgumentException();
            }
        }
    }
}
