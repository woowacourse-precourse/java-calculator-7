package calculator.model.parser;

import calculator.model.validator.InputValidator;
import static calculator.util.Constants.DelimiterNotExitsIntValue;

public class Parser {
    private final InputValidator inputValidator;
    private final String Delimiter="[,:]";
    private String finalDelimiter="";
    private String UserInput;

    public Parser(String input, InputValidator inputValidator) {
        UserInput = input;
        finalDelimiter = Delimiter;
        this.inputValidator = inputValidator;
        findFinalDelimiter();
    }

    public String[] parsingStringToInteger() {
        // finalDelimiter를 기준으로 UserInput을 잘라서 String 배열에 저장
        return UserInput.split(finalDelimiter);
    }

    private void findFinalDelimiter() {
        Object[] result = inputValidator.findCustomDelimiter(UserInput);
        String CustomDelimiter = (String) result[0];
        int startInputIndex = (int) result[1];
        if(startInputIndex!=DelimiterNotExitsIntValue) {
            UserInput = UserInput.substring( startInputIndex);
            finalDelimiter = Delimiter + "|" + CustomDelimiter;
        }
    }

    public long[] convertStringsToNumbers(String[] splitStrings) {
        inputValidator.validateNumbers(splitStrings);

        long[] numbers = new long[splitStrings.length];
        for (int i = 0; i < splitStrings.length; i++) {
            numbers[i] = Long.parseLong(splitStrings[i]);
        }
        return numbers;
    }

}
