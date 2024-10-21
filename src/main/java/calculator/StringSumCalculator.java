package calculator;

import calculator.utils.StringUtils;

import java.util.List;

public class StringSumCalculator {
    public int getTotal(List<String> strings) {
        int total = 0;
        for (String str : strings) {
            total += StringUtils.convert(str);
        }

        return total;
    }
}
