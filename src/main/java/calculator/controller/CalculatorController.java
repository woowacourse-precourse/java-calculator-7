package calculator.controller;

import calculator.entity.IndexQueue;
import calculator.entity.Input;
import calculator.entity.NumList;
import calculator.entity.RefinedInput;
import calculator.entity.RegexStr;
import calculator.entity.SeparatorSet;
import calculator.service.SeparatorService;
import calculator.viewer.ConsoleView;

public class CalculatorController {

    private final SeparatorService separatorService;
    private final ConsoleView consoleView;

    public CalculatorController(SeparatorService separatorService, ConsoleView view) {
        this.separatorService = separatorService;
        this.consoleView = view;
    }

    public void run() {
        consoleView.displayMessage();

        Input input = consoleView.input();

        SeparatorSet separatorSet = separatorService.getCustomSeparators(input);
        RegexStr regexStr = separatorSet.toRegexStr();

        IndexQueue idxQueue = separatorService.getAllCustomSepIdx(input);
        RefinedInput refinedInput = separatorService.refineInput(input, idxQueue);

        NumList numList = separatorService.separateNum(refinedInput, regexStr);
        Integer total = numList.sum();

        consoleView.result(total);
    }
}
