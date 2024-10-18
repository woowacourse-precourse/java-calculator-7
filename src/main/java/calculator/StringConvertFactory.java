package calculator;

public class StringConvertFactory {

    public String[] parseString(String input) {

        if (input.isEmpty()) {
            return new String[]{"0"};
        }
        if (input.matches("\\d+")) {
            return new String[]{input};
        }
        return new String[0];
    }
}
