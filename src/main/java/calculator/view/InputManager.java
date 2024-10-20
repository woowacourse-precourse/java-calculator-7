package calculator.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class InputManager {

    // 정규식을 상수로 정의
    private static final String BASIC_DELIMITER_REGEX = "[,|:]";
    private static final String ONLY_DELIMITER_REGEX = "[,|:]*";
    private static final String NEGATIVE_NUMBER_REGEX = "-\\d+";

    public static String consoleInput() {
        String input = Console.readLine();
        if(input.isEmpty()) return "0";
        if(input.startsWith("//")){
            validateCustomDelimiter(input);
        }
        validateInput(input);
        return input;
    }

    private static void validateInput(String input) {

    }

    private static void validateCustomDelimiter(String input){

    }
}
