package calculator.controller;

import calculator.service.Service;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Service service = new Service();

    public void start(){
        getNumbersProcess();
        plusProcess();
    }

    private void getNumbersProcess(){
        String input = inputView.getString();
        service.saveNumbersSeparator(input);
    }
    private void plusProcess(){
        int sum = service.getSum();
        outputView.printResult(sum);
    }
}
