package calculator;

public class CalculatorService {

    public String extractCustomDelimiter(String readInput) {
        if (readInput.contains("//") && readInput.contains("\\n")) {
            int startPos = readInput.indexOf("//");
            int endPos = readInput.indexOf("\\n");

            return readInput.substring(startPos + 2, endPos);
        }

        return "";
    }

    public String extractPositiveString(String readInput, String customDelimiter) {
        if (!customDelimiter.isBlank()) {
            String remove =  "//" + customDelimiter + "\\n";
            return readInput.replace(remove, "");
        }

        return readInput;
    }

    public String[] splitByPositiveString(String positiveString, String customDelimiter) {
        positiveString = positiveString.replace(",", ":");

        if (!customDelimiter.isBlank())
            positiveString = positiveString.replace(customDelimiter, ":");

        return positiveString.split(":");
    }

    public int[] convertStringArrayToIntArray(String[] numbersString) {
        int[] numbersInt = new int[numbersString.length];

        for (int index = 0; index < numbersInt.length; index++) {
            validString(numbersString[index]);
            numbersInt[index] = Integer.parseInt(numbersString[index]);
        }

        return numbersInt;
    }

    private void validString(String str) {
        if(isNumber(str))
            throw new IllegalArgumentException();
    }

    private boolean isNumber(String str) {
        return !str.matches("[+-]?\\d*(\\.\\d+)?");
    }
}