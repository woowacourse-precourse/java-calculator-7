package calculator.controller;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {


    public void start() {
        startView();


    }


    private InputProcessor readInput() {
        String line = Console.readLine();

        return new InputProcessor(line);

    }

    private void startView() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }


}
