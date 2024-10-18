package calculator.view;

import java.util.NoSuchElementException;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String START_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String EMPTY_VALUE = " ";

    public static String input(){
        startMessage();
        return scanString();
    }

    private static void startMessage(){
        System.out.println(START_MESSAGE);
    }

    private static String scanString(){
        try{
            return  readLine();
        }catch (NoSuchElementException e){
            return EMPTY_VALUE;
        }
    }
}
