package calculator;

public class Application {
    public int stringAdd(String text) {
        if (text == null || text.isBlank()) {
            return 0;
        }
        if (text.contains(",")) {
            String[] numbers = text.split(",");
            int sum = 0;
            for (String number : numbers) {
                sum += Integer.parseInt(number);
            }
            return sum;
        }
        return Integer.parseInt(text);
    }
}
