package calculator.view;


import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String REQUEST_USER_INPUT = "덧셈할 문자열을 입력해 주세요.";
    private String userInput;
    public InputView(){
    }
    public String userInput(){
        System.out.println(REQUEST_USER_INPUT);
        return Console.readLine();
    }
}
