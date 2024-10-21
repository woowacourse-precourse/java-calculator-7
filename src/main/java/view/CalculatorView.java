package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class CalculatorView {

    public CalculatorView() {
    }

    public String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        try {
            return Console.readLine();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("Wrong input.");
        }
    }

    public void displayResult(int result) {
        System.out.println("결과 : " + result);
    }
}
