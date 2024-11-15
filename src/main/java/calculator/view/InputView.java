package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String PROMPT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static InputView inputView;

    private InputView(){
    }

    public static InputView getInstance(){
        if(inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    public String readExpression(){
        System.out.println(PROMPT_MESSAGE);
        return Console.readLine();
    }

    public void closeInputView(){
        if(inputView != null){
            inputView = null;
        }
        Console.close();
    }
}
