package calculator;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    public List<Integer> convert(String[] input) {
        List<Integer> convertedList = new ArrayList<>();

        for (String element : input) {
            convertedList.add(Integer.parseInt(element));
        }

        return convertedList;
    }
}
