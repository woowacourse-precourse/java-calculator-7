package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String getUserInput(){
        System.out.println("숫자를 입력하세요 : ");
        return Console.readLine();
    }
}
