package calculator.view;


import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static final String START_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public String getUserInput(){
        System.out.println(START_MESSAGE);
        return Console.readLine();
    }

}
