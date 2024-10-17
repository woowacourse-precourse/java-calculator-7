package calculator.view;

import java.util.NoSuchElementException;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String START_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private InputView(){}

    public static String scanString(){
        System.out.println(START_MESSAGE);
        String userInput = "";
        try{
            userInput =  readLine();
        }catch (NoSuchElementException e){
            userInput = " ";
        }
        return userInput;
    }
}
