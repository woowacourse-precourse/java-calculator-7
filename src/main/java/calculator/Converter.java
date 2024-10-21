package calculator;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    public List<Integer> convert(String[] input) {
        List<Integer> convertedList = new ArrayList<>();

        for (String element : input) {
            try {
                convertedList.add(Integer.parseInt(element));
            }catch (NumberFormatException e) {
                throw new IllegalArgumentException("양수와 구분자만 입력 가능합니다.");
            }
        }

        return convertedList;
    }
}
