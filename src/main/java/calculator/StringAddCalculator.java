package calculator;

public class StringAddCalculator {

    private final Converter converter = new Converter();
    private final NumberFormatter numberFormatter = new NumberFormatter();

    public String add(String input) {
        if (input.isEmpty()) {
            return "0";
        }

        String[] stringArr = converter.toStringArr(input);

        double sum = 0;

        for (String s : stringArr) {
            sum += Double.parseDouble(s);
        }

        return numberFormatter.format(sum);
    }

}
