package calculator.model.validator;

import calculator.model.Dto.DelimiterInputData;

public class InputValidator implements Validator {

    private String userInput;
    private String bodyInput;
    private Character customDelimiter;

    public InputValidator(String userInput) {
        this.userInput = userInput;
        this.bodyInput = userInput;
        if (!userInput.isEmpty()) {
            validate();
        }
    }

    public void validate() {
        checkForCustomDelimiter();
        validateInputFormat();
    }


    private void checkForCustomDelimiter() {
        if (userInput.matches("^//.\\\\n.*")) {
            validateDelimiterRules(userInput.charAt(2));
            customDelimiter = userInput.charAt(2);
            bodyInput = userInput.substring(5);
        }
    }

    private void validateDelimiterRules(Character userInputDelimiter) {
        if (userInputDelimiter == DelimiterInputData.COLON || userInputDelimiter == DelimiterInputData.COMMA) {
            throw new IllegalArgumentException("기본 연산자는 커스텀 연산자로 사용할 수 없습니다.:" + userInputDelimiter);
        }
        if (userInputDelimiter >= '0' && userInputDelimiter <= '9') {
            throw new IllegalArgumentException("구분자의 문자는 숫자가 될 수 없습니다.:" + userInputDelimiter);
        }
    }

    private void validateInputFormat() {
        for (int i = 0; i < bodyInput.length(); i++) {
            char ch = bodyInput.charAt(i);
            validateCharacter(ch);
        }
    }

    private void validateCharacter(char ch) {
        if ((ch < '1' || ch > '9')
                && ch != DelimiterInputData.COMMA
                && ch != DelimiterInputData.COLON
                && (customDelimiter == null || ch != customDelimiter)) {

            throw new IllegalArgumentException("구분자와 숫자 이외의 문자가 포함된 잘못 된 입력입니다.:" + ch);
        }
    }


    public DelimiterInputData validatedData() {

        return new DelimiterInputData(customDelimiter, bodyInput);
    }
}




