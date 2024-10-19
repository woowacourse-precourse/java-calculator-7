package calculator.service;

import calculator.model.Numbers;
import calculator.validator.NumbersValidator;

import java.util.List;

public class NumbersService {
    public Numbers createNumbers(List<Integer> numbers) {
        return new Numbers(numbers);
    } // createNumbers

    public Numbers createNumbers(String input) {
        int number = new NumbersValidator().validate(input);
        return new Numbers(List.of(number));
    } // createNumbers
} // class