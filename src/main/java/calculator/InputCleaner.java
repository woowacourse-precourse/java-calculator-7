package calculator;

public class InputCleaner {
    public String sanitize(String input) {
        return input.replace("\\n", "\n");  // \n 처리
    }
}
