package calculator;

import calculator.extractor.StringSplitterImpl;
import calculator.converter.NumberConverterImpl;

public class StringCalculator {

    private final StringSplitterImpl stringSplitter;
    private final NumberConverterImpl numberConverter;

    public StringCalculator(StringSplitterImpl stringSplitter, NumberConverterImpl numberConverter) {
        this.stringSplitter = stringSplitter;
        this.numberConverter = numberConverter;
    }

    public int calculate(String input) {
        String[] numbersAsString = stringSplitter.split(input);
        int[] convertedNumbers = numberConverter.convert(numbersAsString);
        return add(convertedNumbers);
    }

    private int add(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
