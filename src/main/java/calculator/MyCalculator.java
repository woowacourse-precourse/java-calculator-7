package calculator;

public class MyCalculator {
    private String numString;

    public MyCalculator(String numString) {
        this.numString = numString;
    }

    private String customSeparator(String str) {
        if (str.startsWith("//") && str.contains("\n")) {
            return Character.toString(str.charAt(2));
        }
        return null;
    }
}
