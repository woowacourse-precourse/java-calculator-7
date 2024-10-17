package calculation;

public class Calculation {

    private static final Calculation INSTANCE = new Calculation();

    private Calculation() {
    }

    public static Calculation getInstance() {
        return INSTANCE;
    }

    public int calculate(String[] numbers) {
        int sum = 0;
        for(String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
