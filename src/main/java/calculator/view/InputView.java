package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputString() {
        System.out.println("덧셈할 문자열을 입력해 주세요. ");
        String inputString = Console.readLine();
        return inputString.replace("\\n", "\n");
    }
}
