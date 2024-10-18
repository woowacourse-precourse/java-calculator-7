package calculator.service;

import calculator.domain.UserInput;
import camp.nextstep.edu.missionutils.Console;

public class InputReceiverService {

    // 사용자에게서 값을 입력받아 UserInput 형태로 반환하는 메서드
    public UserInput getUserInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        return new UserInput(input);
    }
}
