package calculator.domain;

import java.util.List;

public class StringCalculator implements Calculator{

    private final List<String> tokens;

    public StringCalculator(List<String> tokens) {
        this.tokens = tokens;
    }

    @Override
    public Double sum() {
        double total = 0d;
        try {
            for (String token : tokens) {
                if (Double.parseDouble(token) <= 0) {
                    throw new IllegalArgumentException();
                }
                total += Double.parseDouble(token);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return total;
    }
}
