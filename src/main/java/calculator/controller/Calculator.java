package calculator.controller;

import calculator.model.Calculate;
import camp.nextstep.edu.missionutils.Console;

public class Calculator {


    public void start() {
        startView();


    }


    private InputProcessor readInput() {
        String line = Console.readLine();

        InputProcessor inputProcessor = readInput();

        Calculate calculate = new Calculate(inputProcessor.numbers());

        return new InputProcessor(line);

    }

    private void startView() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }


}
