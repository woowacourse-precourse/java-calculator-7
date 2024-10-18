package calculator.controller;

import calculator.delimiterExtractor.DelimiterExtractor;
import calculator.extractorProvider.ExtractorProvider;
import calculator.numberExtractor.NumberExtractor;
import calculator.service.Service;
import java.util.ArrayList;

public class CalculatorController {
    Service service;

    public CalculatorController(Service service) {
        this.service = service;
    }

    public void execute() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = camp.nextstep.edu.missionutils.Console.readLine();

        String inputType = service.checkTypeOfInput(input);
        DelimiterExtractor delimiterExtractor = ExtractorProvider.getDelimiterExtractor(inputType);
        NumberExtractor numberExtractor = ExtractorProvider.getNumberExtractor(inputType);

        String extractedDelimiter = service.extractDelimiter(delimiterExtractor, input);
        ArrayList<Integer> extractNumbers = service.extractNumbers(extractedDelimiter, numberExtractor, input);
        int sum = service.addAll(extractNumbers);
        System.out.println("결과 : " + sum);


    }


}