package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    // 생성자
    public InputView() {
    }

    // 사용자로부터 덧셈할 문자열을 입력받는 메서드
    public String input() {
        // ViewMessage enum을 사용해 입력 메시지를 출력
        System.out.println(ViewMessage.INPUT_PROMPT.getMessage());
        return Console.readLine();
    }

}