package calculator.domain;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    private String firstInput;
    private String secondInput;


    public void readFirstInput() {
        firstInput = Console.readLine();
    }

    public String getFirstInput() { //???
        return firstInput;
    }

    // 입력이 기본 형식인지 커스텀 형식인지 판단하는 메소드
    public boolean isDefaultInput() {
        return !firstInput.startsWith("//");
    }


}
