package calculator;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorView {

    // 우테 input 값을 받기.
    public String getInput() {
        return Console.readLine();
    }

    // 결과 출력
    public void printResult(int result){
        System.out.println("결과 : " + result);
    }
}
