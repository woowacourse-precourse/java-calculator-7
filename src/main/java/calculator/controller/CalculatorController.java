package calculator.controller;

import calculator.model.Calculator;
import calculator.model.CustomSeparators;
import calculator.model.Numbers;
import calculator.model.Separators;
import calculator.service.NumbersService;
import calculator.service.SeparatorsService;
import calculator.view.InputReader;
import calculator.view.OutputView;

import java.util.List;

import static calculator.constant.Message.*;

public class CalculatorController {
    private final SeparatorsService separatorsService;
    private final NumbersService numbersService;
    private final Calculator calculator;

    public CalculatorController(SeparatorsService separatorsService,
                                NumbersService numbersService,
                                Calculator calculator) {
        this.separatorsService = separatorsService;
        this.numbersService = numbersService;
        this.calculator = calculator;
    } // CalculatorController

    public void run() {
        OutputView.displayStart();
        String input = InputReader.inputMessage();

        Numbers numbers = createNumbers(input);

        int result = calculator.calculateSum(numbers);
        OutputView.displayResult(result);
    } // run

    public Numbers createNumbers(String input) {
        if (containsSeparator(input)) {
            Separators separators = separatorsService.createSeparator(input);
            List<Integer> separatedNumbers = separateNumbers(separators, input);
            return numbersService.createNumbers(separatedNumbers);
        } // end if

        return numbersService.createNumbers(input);
    } // createNumbers

    private List<Integer> separateNumbers(Separators separators, String input) {
        if (separators instanceof CustomSeparators) {
            String calculatePart = separatorsService.getCalculatePart(input);
            return separators.separateNumbers(calculatePart);
        } // end if

        return separators.separateNumbers(input);
    } // getNumbers

    public boolean containsSeparator(String input) {
        return input.matches(CUSTOM_SEPARATE_REGEX)
                || (input.contains(FIRST_DEFAULT_SEPARATOR)
                || input.contains(SECOND_DEFAULT_SEPARATOR));
    } // containsSeparator
} // class