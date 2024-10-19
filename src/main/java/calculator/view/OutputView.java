package calculator.view;

import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.Locale;

public class OutputView {

    public void printResult(final String total) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.KOREA);
        System.out.println("결과 : " + numberFormat.format(new BigInteger(total)));
    }

}
