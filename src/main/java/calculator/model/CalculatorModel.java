package calculator.model;

public class CalculatorModel {

    public String[] StringSplitter(String input) {

        String delimiter = ",|:";
        String[] numbers = input.split(delimiter);

        return numbers;
    }
}
