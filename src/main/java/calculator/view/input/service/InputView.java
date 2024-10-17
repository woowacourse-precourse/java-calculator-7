package calculator.view.inputView.service;

import camp.nextstep.edu.missionutils.Console;

public class InputView implements InputService{

    @Override
    public String input() {
        String input = Console.readLine();
        return input;
    }
}
