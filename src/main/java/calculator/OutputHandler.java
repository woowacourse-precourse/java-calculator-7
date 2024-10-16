package calculator;

public class OutputHandler {
    public String getOutPut(String input) {
        if (input.isEmpty()) {
            return "결과 : 0";
        }
        return "결과 : " + input;
    }
}
