package calculator;

import java.text.DecimalFormat;

public class NumberFormatter {

    public String format(double sum) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00#");

        if (sum % 1 == 0) {
            decimalFormat = new DecimalFormat("0");
            return decimalFormat.format(sum);
        }

        return decimalFormat.format(sum);
    }
}
