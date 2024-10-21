package calculator.view;

import camp.nextstep.edu.missionutils.Console;


public class InputView {

    /**
     * 문자열 입력
     *
     * @return 사용자가 입력한 문자열
     */
    public String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        Console.close();

        return input;
    }

}
