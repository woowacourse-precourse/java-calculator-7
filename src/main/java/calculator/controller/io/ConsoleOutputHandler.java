package calculator.controller.io;

import calculator.view.ConsoleView;

public class ConsoleOutputHandler implements OutputHandler {
    // 콘솔에 결과를 출력하는 역할을 하는 View 객체를 필드로 선언
    private final ConsoleView consoleView = new ConsoleView();

    //displayResult 메서드를 구현
    @Override
    public void displayResult(Integer result) {
        consoleView.displayResult(result);
    }
}
