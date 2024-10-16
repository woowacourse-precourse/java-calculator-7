package calculator;

public class CalculatorService {

    public String extractCustomDelimiter(String readInput) {
        if (readInput.contains("//") && readInput.contains("\\n")) {
            int startPos = readInput.indexOf("//");
            int endPos = readInput.indexOf("\\n");

            return readInput.substring(startPos + 2, endPos);
        }

        return null;
    }
}