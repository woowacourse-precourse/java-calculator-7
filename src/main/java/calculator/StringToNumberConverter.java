package calculator;

import java.util.ArrayList;
import java.util.List;

public class StringToNumberConverter {
    public List<Integer> convert(List<String> input) {
        List<Integer> result = new ArrayList<>();
        for (String s : input) {
            try {
                result.add(Integer.parseInt(s));
            } catch (NumberFormatException e) {
                result.add(0);
            }
        }
        return result;
    }


}