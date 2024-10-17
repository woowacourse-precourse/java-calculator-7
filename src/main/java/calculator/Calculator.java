package calculator;

import java.text.DecimalFormat;

public class  Calculator {
    public String calculate(String input) {

        StringFilter stringFilter = new StringFilter();
        DecimalFormat df = new DecimalFormat("#.##");
        if (input.isEmpty())
            return df.format(0);

        if (input.length() == 1)
            return df.format(Double.parseDouble(input));

        String[] numbers = stringFilter.StringController(input);
        Double sum = 0.D;

        for (String numberStr : numbers) {
            sum += Double.parseDouble(numberStr);
        }
        return df.format(sum);
    }
}
