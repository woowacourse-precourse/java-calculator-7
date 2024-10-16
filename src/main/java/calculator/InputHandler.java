package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

    public enum DelimiterType {
        EMPTY, DEFAULT, CUSTOM
    }

    public String getUserInput(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine().trim();
    }

    private boolean isDefaultDelimiter(String userInput){
        return false;
    }

    private boolean isCustomDelimiter(String userInput){
        return false;
    }

    public DelimiterType isValidInput(String userInput){
        if (userInput.isEmpty()) return DelimiterType.EMPTY;
        if (isDefaultDelimiter(userInput)) return DelimiterType.DEFAULT;
        if (isCustomDelimiter(userInput)) return DelimiterType.CUSTOM;
        throw new IllegalArgumentException();
    }

    private int[] handleDefaultDelimiter(String userInput){
        return new int[0];
    }

    private int[] handleCustomDelimiter(String userInput){
        return new int[0];
    }

    public int[] stringToIntArray(String userInput, DelimiterType delimiterType){
        if (delimiterType == DelimiterType.EMPTY) return new int[0];
        if (delimiterType == DelimiterType.DEFAULT) return handleDefaultDelimiter(userInput);
        if (delimiterType == DelimiterType.CUSTOM) return handleCustomDelimiter(userInput);
        return null;
    }
}
