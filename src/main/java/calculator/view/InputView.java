package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    /**
     * 고정 메세지 출력
     */
    public void printMessage(String message)
    {
        System.out.println(message);
    }

    /**
     * 사용자로부터 문자열 입력 받음
     */
    public void getUserInput()
    {
        String invalidateString = Console.readLine();
    }
}

