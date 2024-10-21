package calculator;

public class DefaultInputValidator extends InputValidator {

    public DefaultInputValidator(String input, String delimiter) {
        super(input, delimiter);
    }

    @Override
    public boolean isValidInput() {
        if (recursivelyIterateInput(0, this.input.length()))
            return true;
        throw new IllegalArgumentException();
    }

    private boolean recursivelyIterateInput(int idx, int inputLength) {
        if (inputLength <= idx) {
            return true;
        }
        char currentChar = input.charAt(idx);
        if (currentChar == ':' || currentChar == ',' || Character.isDigit(currentChar)) {
            return recursivelyIterateInput(idx + 1, inputLength);
        }
        return false;
    }
}

