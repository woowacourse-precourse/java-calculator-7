package calculator.controller;

import calculator.model.Calculate;
import camp.nextstep.edu.missionutils.Console;

public class Calculator {


    public void start() {
        startView();

        InputProcessor inputProcessor = readInput();

        Calculate calculate = new Calculate(inputProcessor.numbers());

        resultView(calculate.sum());

    }


    private InputProcessor readInput() {
        String line = Console.readLine();

        return new InputProcessor(line);

    }

    private void startView() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    private void resultView(Long result) {
        System.out.println("결과 : " + result);
    }

}
