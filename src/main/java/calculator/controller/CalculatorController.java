package calculator.controller;

import calculator.delimiterExtractor.DelimiterExtractor;
import calculator.extractorProvider.ExtractorProvider;
import calculator.numberExtractor.NumberExtractor;
import calculator.service.Service;
import calculator.validator.Validator;
import calculator.view.View;
import java.util.ArrayList;

public class CalculatorController {
    Service service;
    Validator validator;

    public CalculatorController(Service service, Validator validator) {
        this.service = service;
        this.validator = validator;
    }

    public void execute() {
        String input = View.getInput();

        ExtractorProvider extractorProvider = new ExtractorProvider(validator);
        String inputType = service.checkTypeOfInput(input, validator);
        DelimiterExtractor delimiterExtractor = extractorProvider.getDelimiterExtractor(inputType);
        NumberExtractor numberExtractor = extractorProvider.getNumberExtractor(inputType);

        String extractedDelimiter = service.extractDelimiter(delimiterExtractor, input);
        ArrayList<Integer> extractNumbers = service.extractNumbers(extractedDelimiter, numberExtractor, input);
        int sum = service.addAll(extractNumbers);

        View.showResult(sum);


    }


}