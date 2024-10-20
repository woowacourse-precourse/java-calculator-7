package calculator;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    public static List<Integer> convertStringToInteger(List<String> numbers) {
        List<Integer> result = new ArrayList<>();

        for (String number : numbers) {
            if (number.equals("")) {
                result.add(0);
            }
            else {
                result.add(Integer.parseInt(number));
            }
        }

        return result;
    }
}
