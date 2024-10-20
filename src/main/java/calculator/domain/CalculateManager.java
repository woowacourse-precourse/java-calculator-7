package calculator.domain;

import calculator.domain.number.Numbers;
import calculator.domain.separator.Separators;
import calculator.global.util.Validator;
import calculator.ui.InputView;
import calculator.ui.OutputView;
import java.util.Arrays;

public class CalculateManager {
    private final InputView inputView;
    private final OutputView outputView;
    private final LetterManager letterManager;
    private final Calculator calculator;
    private final CustomSeparatorSplitter customSeparatorSplitter;
    private final Separators separators;
    private final NumberSplitter numberSplitter;
    private final Numbers numbers;


    public CalculateManager() {
        inputView = new InputView();
        outputView = new OutputView();
        customSeparatorSplitter = new CustomSeparatorSplitter();
        separators = new Separators();
        numbers = new Numbers();
        numberSplitter = new NumberSplitter();
        letterManager = new LetterManager();
        calculator = new Calculator();
    }

    public void start() {
        printReadLettersMessage();
        String letters = readLetters();
        String[] customSeparators = extractCustomSeparator(letters);
        String newLetters = ReplaceCustomSeparatorToSeparator(letters, customSeparators);
        registerCustomSeparator(customSeparators);
        String[] extractedNumbers = getNumbersFromLetters(newLetters);
        registerNumbers(extractedNumbers);
        int sum = calculateSum();
        printResult(sum);
    }

    private int calculateSum() {
        return calculator.sumNumbers(numbers);
    }

    private String[] getNumbersFromLetters(String newLetters) {
        return numberSplitter.getNumbersFromLetters(newLetters, separators);
    }

    private String ReplaceCustomSeparatorToSeparator(String letters, String[] customSeparators) {
        return letterManager.replaceCustomSeparatorToSeparator(letters, customSeparators);
    }

    private void registerNumbers(String[] extractedNumbers) {
        Arrays.stream(extractedNumbers)
                .filter(number -> !number.isEmpty())
                .forEach(number -> {
                    Validator.validateSeparator(number);
                    numbers.addNumber(number);
                });
    }

    private String[] extractCustomSeparator(String letters) {
        return customSeparatorSplitter.extractCustomSeparatorFromLetters(letters);
    }

    private void registerCustomSeparator(String[] customSeparators) {
        Arrays.stream(customSeparators)
                .forEach(separators::addSeparator);
    }

    private void printResult(int result) {
        outputView.printResult(result);
    }

    private String readLetters() {
        return inputView.readLetters();
    }

    private void printReadLettersMessage() {
        outputView.printReadLettersMessage();
    }


}