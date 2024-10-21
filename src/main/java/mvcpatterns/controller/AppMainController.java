package mvcpatterns.controller;

import camp.nextstep.edu.missionutils.Console;
import java.nio.charset.StandardCharsets;
import mvcpatterns.view.AppView;

public class AppMainController {


    AppView viewer;
    IntegerMathController integerMathController;
    ParsingController parsingController;

    public AppMainController() {
        viewer = new AppView();
        integerMathController = new IntegerMathController();
        parsingController = new ParsingController();
    }

    public void doTask() {

        this.viewer.printStartMessage();
        String input = Console.readLine();
        this.validateInput(input);

        String[] numList = this.parsingController.extractNumbers(input);

        String result = this.integerMathController.sumPositiveInteger(numList);

        this.viewer.printEndMessage(result);

    }

    private void validateInput(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("Input string is empty. please check input");
        }

        //validate Whether input is utf-8 endcoded or not
        try {
            byte[] utf8Bytes = input.getBytes(StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new IllegalArgumentException("Input can't be encoded to utf-8. please check it");
        }

    }


}
