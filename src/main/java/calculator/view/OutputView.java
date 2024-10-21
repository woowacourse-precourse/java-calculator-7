package calculator.view;

import calculator.domain.Result;

/**
 * 출력값과 관련된 기능을 정의한 인터페이스
 */
public interface OutputView {

    void printResult(Result totalSum);
}
