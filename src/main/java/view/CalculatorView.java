package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class CalculatorView {

    public String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요:");
        try {
            return Console.readLine().trim();
        } catch (NoSuchElementException e) {
            System.out.println("입력이 없습니다.");
            return "";
        }
    }

    public void showResult(int result) {
        System.out.printf("결과 : %d%n", result);

    }
}
