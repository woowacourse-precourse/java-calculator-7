package calculator;

public class Calculator {

    int sumFromString(String inputString) {
        if (inputString.isEmpty()) {
            return 0;
        }

        Delimiter delimiter = new Delimiter(inputString);
        String[] delimitedNumbers = delimiter.getDelimitedNumbers();

        NumberValidator validator = new NumberValidator();
        validator.NegativeOrZeroCheck(delimitedNumbers);

        return addingNumbers(delimitedNumbers);
    }

    private int addingNumbers(String[] delimitedNumbers) {
        int result = 0;
        for (String delimitedNumber : delimitedNumbers) {
            result += Integer.parseInt(delimitedNumber);
        }
        return result;
    }
}