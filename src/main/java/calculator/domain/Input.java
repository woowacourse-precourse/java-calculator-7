package calculator.domain;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    private static String firstInput;
    private static String secondInput;


    public void readFirstInput() {
        firstInput = Console.readLine();
    }

    public void readSecondInput() {
        secondInput = Console.readLine();
    }

    // 입력이 기본 형식인지 커스텀 형식인지 판단하는 메소드
    public boolean isDefaultInput() {
        if (firstInput.startsWith("//")) {
            firstInput = firstInput.substring(2);
            return false;
        }
        return true;
    }

    public String getFirstInput() { //???
        return firstInput;
    }


}
