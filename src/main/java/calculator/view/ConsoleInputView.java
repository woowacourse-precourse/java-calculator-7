package calculator.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 콘솔을 통해 입력값과 관련된 기능을 수행하는 클래스
 */
public class ConsoleInputView implements InputView {

    @Override
    public String getNextLine() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }
}
