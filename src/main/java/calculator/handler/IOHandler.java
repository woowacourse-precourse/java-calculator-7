package calculator.handler;

import camp.nextstep.edu.missionutils.Console;

public class IOHandler {
    private static final String INPUT_PROMPT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public  String input(){
        System.out.println(INPUT_PROMPT_MESSAGE);
        String input =  Console.readLine();
        if(input.isEmpty()){
            throw new IllegalArgumentException("입력값이 존재하지 않습니다.");
        }
        return input;
    } //입력
}
