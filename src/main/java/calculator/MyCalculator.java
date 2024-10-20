package calculator;

import calculator.command.DelimiterLine;
import calculator.command.NumbersLine;
import calculator.delimiter.Delimiter;
import calculator.number.NumbersReader;

import java.util.Arrays;

public class MyCalculator {
    private final NumbersReader numbersReader;

    public MyCalculator(NumbersReader numbersReader) {
        this.numbersReader = numbersReader;
    }

    public int calculate(DelimiterLine delimiterLine, NumbersLine numbersLine) {
        Delimiter delimiter = Delimiter.create(delimiterLine);
        return sum(numbersReader.readNumbers(numbersLine, delimiter));
    }

    private int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }
}
