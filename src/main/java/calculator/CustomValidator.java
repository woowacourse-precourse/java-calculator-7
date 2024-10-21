package calculator;

public class CustomValidator {

    InputParser inputParser;

    public CustomValidator(InputParser inputParser) {
        this.inputParser = inputParser;
    }

    public boolean validate(String inputData) {
        if (inputData.matches("\\d*")) {
            return false;
        } else if (inputData.matches("^(\\d+([,:]\\d+)*)*$")) {
            return false;
        } else {
            return customValidate(inputData);
        }
    }

    public boolean customValidate(String inputData) {
        if (inputData.matches("^//(.*?)\\\\n.*")) {
            inputParser.addSeparactor(inputParser.parseCustomSeparator(inputData));
            String separators = inputParser.concatSeparactor();
            String dataWithoutCustomSeparator = inputParser.removeCustomSeparactor(inputData);
            if (dataWithoutCustomSeparator.matches("\\d*") || dataWithoutCustomSeparator.matches(
                    String.format("(\\d+([\\d%s]*)*)$", separators))) {
                return true;
            } else {
                throw new IllegalArgumentException("잘못된 값 입력");
            }
        } else {
            throw new IllegalArgumentException("잘못된 값 입력");
        }
    }
}
