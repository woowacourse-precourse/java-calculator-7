package calculator;

public class Calculator {
    public static int add(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        String[] values = text.split(",|:");
        return sum(values);
    }

    private static int sum(String[] values) {
        int sum = 0;
        for (String value : values) {
            sum += Integer.parseInt(value);
        }
        return sum;
    }
}
