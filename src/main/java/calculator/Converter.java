package calculator;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    public List<Integer> convert(String[] input) {
        List<Integer> convertedList = new ArrayList<>();

        for (String element : input) {
            if (element.isEmpty()) {
                continue;
            }
            convertedList.add(Integer.parseInt(element));
        }

        return convertedList;
    }
}
