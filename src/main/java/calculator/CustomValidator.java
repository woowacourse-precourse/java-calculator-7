package calculator;

public class CustomValidator {
    
    public static boolean validate(String inputData) {
        if (inputData.matches("\\d*")) {
            return false;
        } else if (inputData.matches("^(\\d+([,:]\\d+)*)*$")) {
            return false;
        } else {
            return customValidate(inputData);
        }
    }

    public static boolean customValidate(String inputData) {
        if (inputData.matches("^//(.*?)\\\\n.*")) {
            String customSeparator = InputParser.parseSeparator(inputData);
            String newData = InputParser.customParse(inputData);
            InputHandler.inputData = newData;
            if (newData.matches(String.format("(\\d+([\\d,:%s]*)*)$", customSeparator))) {
                return true;
            } else {
                throw new IllegalArgumentException("잘못된 값 입력");
            }
        } else {
            throw new IllegalArgumentException("잘못된 값 입력");
        }
    }
}
