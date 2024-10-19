package calculator;

public class Application {
    public int stringAdd(String text) {
        if (text == null || text.isBlank()) {
            return 0;
        }
        return Integer.parseInt(text);
    }
}
