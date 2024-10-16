package calculator.controller;

import calculator.service.DelimiterService;
import calculator.view.InputView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculatorController {

    InputView inputView = new InputView();
    DelimiterService delimiterService = new DelimiterService();
    List<String> initialDelimiters = new ArrayList<>(Arrays.asList(",", ":"));

    public void run() {
        String userInput = inputView.input("덧셈할 문자열을 입력해 주세요.");
        delimiterService.addDelimiters(initialDelimiters);
    }
}
