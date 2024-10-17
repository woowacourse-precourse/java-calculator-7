package calculator.view;

import calculator.enums.UIMessages;

public class OutputView {
    public void printResult(int result) {
        //TODO: 결과 출력 구현
        System.out.println(UIMessages.OUTPUT_RESULT.getMessage() + result);
    }
}
