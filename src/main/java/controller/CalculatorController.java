package controller;

import view.InputView;

public class CalculatorController {
    public void run() {
        String input = InputView.getInput();
        System.out.println("입력한 값: " + input); // 입력값이 잘 출력되는지 확인
    }
}