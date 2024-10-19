package calculator;

public class DelimiterParser {

    public String[] splitByDelimiter(String userInput) {
        var inputHandler = new InputHandler();

        if(inputHandler.isCustomDelimiterPresent(userInput)){
            char customDelimiter = inputHandler.extractCustomDelimiter(userInput);
            userInput = retainAdditionString(userInput);
            userInput = userInput.replace(customDelimiter, ' ');
        }
        userInput = userInput.replace(',',' ');
        userInput = userInput.replace(':', ' ');

        return userInput.split(" ");
    }

    // 덧셈할 문자열만 남기는 메서드 (커스텀 구분자 문자열 제거)
    private String retainAdditionString(String userInput) {
        return userInput.substring(5);
    }
}
