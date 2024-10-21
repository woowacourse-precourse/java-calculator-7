package calculator.view;

import calculator.domain.Result;

public class ConsoleOutputView implements OutputView {

    @Override
    public void printResult(Result totalSum) {
        System.out.println("결과 : " + totalSum);
    }
}
