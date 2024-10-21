package calculator.view;

import calculator.domain.Result;

/**
 * 콘솔을 통해 출력값과 관련된 기능을 수행하는 클래스
 */
public class ConsoleOutputView implements OutputView {

    @Override
    public void printResult(Result totalSum) {
        System.out.println("결과 : " + totalSum);
    }
}
