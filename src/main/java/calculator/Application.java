package calculator;

public class Application {
    private String processNull(String input) {
        if (input == null || input.isEmpty()) {
            return "0";
        }
        return input;
    }

    private String extractCustomSymbols(String input) {
        if (input.indexOf("/") == 0) {
            int startIndex = input.indexOf("/") + 2;
            int endIndex = input.indexOf("\\");
            return input.substring(startIndex, endIndex);
        }
        return "";
    }

    private void validateInput(String input, String custom) {
        if (!custom.isEmpty()) {
            if (custom.matches("^[0-9]*$")) {
                throw new IllegalArgumentException();
            }
            String subInput = input.substring(5);
            String allowedCharsPattern = "^[0-9, : " + custom + "]*$";
            if (!subInput.matches(allowedCharsPattern)) {
                throw new IllegalArgumentException();
            }
        } else {
            String allowedCharsPattern = "^[0-9, :]*$";
            if (!input.matches(allowedCharsPattern)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private String[] splitString(String input, String custom) {
        if (custom.isEmpty()) {
            return input.split("[,:]");
        } else {
            return input.substring(5).split("[,:" + custom + "]");
        }
    }

    private int sumArray(String[] arr) {
        int sum = 0;
        for (String value : arr) {
            if (!value.isEmpty()) {
                sum += Integer.parseInt(value);
            }
        }
        return sum;
    }
}