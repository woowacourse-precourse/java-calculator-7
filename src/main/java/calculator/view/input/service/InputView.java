package calculator.view.input.service;

import calculator.view.input.validator.InputValidator;
import calculator.view.output.InfoService;
import camp.nextstep.edu.missionutils.Console;


public class InputView implements InputService{
    private final InfoService infoService;
    public InputView(InfoService infoService) {
        this.infoService = infoService;
    }
    @Override
    public String input() {
        infoService.info();
        String input = Console.readLine();
        InputValidator.validator(input);
        return input;
    }
}

