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
}