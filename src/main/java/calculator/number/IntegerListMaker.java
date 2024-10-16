package calculator.number;

import calculator.validation.NumberValidation;

import java.util.ArrayList;
import java.util.List;

public class IntegerListMaker {

    public static List<Integer> getNumberList(List<String> stringList) {
        List<Integer> numberList = new ArrayList<>();
        // 빈 리스트가 들어왔을 경우
        if (stringList.isEmpty()) {
            return numberList;
        }

        for (String string : stringList) {
            NumberValidation.validation(string); // 양수인지 검증
            numberList.add(Integer.parseInt(string));
        }
        return numberList;
    }
}
