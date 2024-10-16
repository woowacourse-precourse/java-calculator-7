package calculator.number;

import calculator.validation.AlphabetValidation;
import calculator.validation.NumberValidation;

import java.util.ArrayList;
import java.util.List;

public class IntegerListMaker {

    public static List<Integer> getNumberList(List<String> stringList) {
        List<Integer> numberList = new ArrayList<>();
        for (String string : stringList) {
            AlphabetValidation.alphabet(string);
            NumberValidation.number(string);
            numberList.add(Integer.parseInt(string));
        }
        return numberList;
    }
}
