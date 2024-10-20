package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String readUserString() {
        String readLine = Console.readLine();
        if (readLine.isEmpty()){
            throw new IllegalArgumentException("[ERROR] : 공백을 허용하지 않습니다.");
        }
        return readLine;
    }
}