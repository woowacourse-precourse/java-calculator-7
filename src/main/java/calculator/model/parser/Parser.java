package calculator.model.parser;

import calculator.model.validator.InputValidator;

public class Parser {
    private final InputValidator inputValidator;
    private String Delimiter="[,:]";
    private String finalDelimiter="";
    private String UserInput;

    public Parser(String input, InputValidator inputValidator) {
        UserInput = input;
        finalDelimiter = Delimiter;
        this.inputValidator = inputValidator;
        findCustomDelimiterAndApplyInput();
    }

    public String[] parsingStringToInteger() {
        // finalDelimiter를 기준으로 UserInput을 잘라서 String 배열에 저장
        return UserInput.split(finalDelimiter);
    }

    private void findCustomDelimiterAndApplyInput() {
        String CustomDelimiter = inputValidator.findCustomDelimiter(UserInput);
        if(!CustomDelimiter.equals("")) {
            UserInput = UserInput.substring(5);
            finalDelimiter = Delimiter + "|" + CustomDelimiter;
        }
    }

}
