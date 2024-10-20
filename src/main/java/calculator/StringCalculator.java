package calculator;

public class StringCalculator {

    public int add(String text) {
        if (isBlank(text)) {
            return 0;
        }
        int sum = 0;
        String[] split = text.split(",|:");
        for (String number : split) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }

    private boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }
}
