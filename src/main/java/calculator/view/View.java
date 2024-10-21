package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class View {

    public String inputAddedNumber() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine().trim();
    }

    public void outputAddedResult(int number) {
        System.out.println("결과 : " + number);
    }
}
