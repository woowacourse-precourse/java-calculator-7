package calculator.Utils;

import java.text.DecimalFormat;

public class NumberFormatter {
    DecimalFormat decimalFormat = new DecimalFormat("#.################");

    public String format(Double sum) {
        return decimalFormat.format(sum);
    }
}
