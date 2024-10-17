package calculator;

import java.util.ArrayList;
import java.util.List;

public class AddCalculator {

    private List<Integer> numbers = new ArrayList<>();

    public AddCalculator(String str, String separator, String format) {
        if(format.equals("custom")) {
            separate(str.substring(5), separator);
        } else {
            separate(str, separator);
        }
    }

    private void separate(String str, String separator) {

        String[] tokens = str.split("[" + separator + "]");

        for(String token : tokens) {
            numbers.add(Integer.parseInt(token));
        }
    }

    public int calculate() {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }
}
