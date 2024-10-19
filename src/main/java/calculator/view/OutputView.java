package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class OutputView {

    // 계산 결과를 출력하는 메소드
    public void printOutput(String output) {
        System.out.println("결과 : " + output);
        Console.close();
    }

}
