package calculator;

public class Validator {
    public void checkInputValid(String str) {
        for (char x : str.toCharArray()) {
            if (!Character.isDigit(x)) {
                throw new IllegalArgumentException(Constants.STRING_ERROR_MESSAGE1);
            } else {
                if (Integer.parseInt(str) == 0) {
                    throw new IllegalArgumentException(Constants.STRING_ERROR_MESSAGE2);
                }
            }
        }
    }

    public void checkCustomStyle(String str) {
        if (!str.startsWith(Constants.CUSTOM_DELIMITER_FRONT)) {
            throw new IllegalArgumentException(Constants.CUSTOM_ERROR_MESSAGE1);
        }
    }

    public void checkCustomEmpty(String str) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException(Constants.CUSTOM_ERROR_MESSAGE2);
        }
    }

}
