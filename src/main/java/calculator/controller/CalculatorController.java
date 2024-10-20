package calculator.controller;

import calculator.domain.Candidate;
import calculator.domain.Storage;
import calculator.model.Calculator;
import calculator.model.Extractor;
import calculator.model.Validator;
import calculator.utils.Converter;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class CalculatorController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Validator validator;
    private final Extractor extractor;
    private final Calculator calculator;
    private final Storage storage;

    public CalculatorController(InputView inputView, OutputView outputView,
                                Validator validator, Extractor extractor,
                                Calculator calculator, Storage storage) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.validator = validator;
        this.extractor = extractor;
        this.calculator = calculator;
        this.storage = storage;
    }

    public void start() {
        String input = getInput();
        extractDelimitersAndNumber(input);
        validateInputAndNumber(input, storage.getNumberCandidates());
        printResult(getSum(storage.getNumberCandidates()));
    }

    private void printResult(int result) {
        outputView.printResult(result);
    }

    private int getSum(List<Candidate> candidates) {
        return calculator.addAll(Converter.candidateToInt(candidates));
    }

    private void validateInputAndNumber(String input, List<Candidate> candidates) {
        validator.execute(input, candidates);
    }

    private void extractDelimitersAndNumber(String input) {
        extractor.execute(input, storage);
    }

    private String getInput() {
        inputView.printStartMessage();
        return inputView.getInputMessage();
    }
}
