package calculator.controller;

import calculator.model.Delimiter;
import calculator.model.Extractor;
import calculator.model.Numbers;

import java.util.List;

public class Controller {

    private Delimiter delimiter;
    private Extractor extractor;
    private Numbers numbers;

    public Controller(Delimiter delimiter, Extractor extractor, Numbers numbers) {
        this.delimiter = delimiter;
        this.extractor = extractor;
        this.numbers = numbers;
    }

    public Integer execute(String input) {
        List<String> defaultDelimiters = delimiter.getDefaultDelimiters();
        System.out.println(defaultDelimiters);
        List<Integer> inputNumbers = extractor.extractNumbers(input, defaultDelimiters.toArray(new String[0]));

        numbers.addNumber(inputNumbers.toArray(new Integer[0]));
        return numbers.sumNumbers();
    }


}
