package calculator.controller;

import calculator.view.OutputView;

public class OutputController {
    private OutputView outputView = new OutputView();
    
    // 결과물을 넘겨받아서 출력을 호출
    public void writeResult(int result) {
        outputView.printResult(result);
    }
}
