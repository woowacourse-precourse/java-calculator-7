package refactor;

public class Calculator {

    int add(String inputString) {
        if (inputString.isEmpty()) {
            return 0;
        }

        Delimiter delimiter = new Delimiter(inputString);
        String[] delimitedNumbers = delimiter.getDelimitedNumbers();

        NumberValidator validator = new NumberValidator();
        validator.NegativeOrZeroCheck(delimitedNumbers);

        CalculatorMethod CalculatorMethod = new CalculatorMethod();
        return CalculatorMethod.add(delimitedNumbers);
    }
}
