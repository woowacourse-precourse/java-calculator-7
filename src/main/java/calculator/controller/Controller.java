package calculator.controller;

import calculator.exception.Exceptions;
import calculator.model.InputString;
import calculator.model.ResultNumbers;
import calculator.service.MainService;
import calculator.view.InputMessage;
import calculator.view.OutputMessage;
import camp.nextstep.edu.missionutils.Console;

public class Controller {

    private MainService mainService = new MainService();
    private Exceptions exceptions = new Exceptions();
    private InputString inputString;
    private ResultNumbers resultNumbers;

    public void start() {
        getString();
        getNumberList();
        getResultNum();
    }

    private void getString() {
        InputMessage.inputString();
        String input = Console.readLine().trim();

        exceptions.validateColonDelimiter(input);
        exceptions.validateCommaDelimiter(input);

        inputString = new InputString(input);
        mainService.getCustomDelimiter(inputString);

        exceptions.validateLeadingCustomDelimiter(inputString.getInputString(), inputString.getCustomDelimiter());
        exceptions.validateCustomDelimiter(inputString.getInputString(), inputString.getCustomDelimiter());
    }

    private void getNumberList() {
        resultNumbers = new ResultNumbers();
        mainService.extractSlashFromString(inputString);
        exceptions.validateLeadingDelimiter(inputString.getInputString());

        mainService.extractNumbersFromString(inputString, resultNumbers);
        exceptions.validateNegativeNumbers(resultNumbers.getNumberList());
    }

    private void getResultNum() {
        OutputMessage.resultMessage(mainService.getResultNumber(resultNumbers));
    }


}
