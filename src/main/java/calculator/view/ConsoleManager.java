package calculator.view;

import calculator.parser.ParserSelector;
import calculator.parser.StringParser;

import java.util.List;

public class ConsoleManager {
    private final static String WELCOME_MESSAGE = "덧셈할 문자열을 입력해주세요.";
    private final static String RESULT_MESSAGE = "결과 : ";
    public void run(){
        printWelcomeMessage();

        String str = InputManager.consoleInput();

        StringParser parser = ParserSelector.select(str);
        List<String> list = parser.parse(str);
//        int result = Calculator.sum(list);
//
//        printResultMessage(result);
    }
    public void printWelcomeMessage(){
        System.out.println(WELCOME_MESSAGE);
    }
    public void printResultMessage(int result){
        System.out.println(RESULT_MESSAGE + result);
    }
}
