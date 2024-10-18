package calculator.logic;

import calculator.util.ValidationUtil;
import java.util.ArrayList;
import java.util.List;

public class CalculatorInputParser {
    private final ValidationUtil validationUtil = new ValidationUtil();

    public List<Integer> splitInitialString(String initialString) {
        String seporators = ",|:";

//        !@#$%^&* 특수문자 고려
        if (initialString.startsWith("//")) {
            seporators = seporators + "|" + setExtraSeparator(initialString);
            initialString = initialString.substring(5);
        }
//        System.out.println(seporators);
//        for (Character c : seporators) {
////            구분자 어떻게 처리할건지...
//            String[] s = initialString.split(Character.toString(c));
//        }

        String[] numList = initialString.split(seporators);
        List<Integer> integerList = new ArrayList<>();

        for (String s : numList) {
            if (s.isEmpty()) {
                integerList.add(0);
                continue;
            }
            validationUtil.isValidNumber(s);
            integerList.add(Integer.valueOf(s));
//            System.out.println(Integer.valueOf(s));
        }
        return integerList;

    }

    private Character setExtraSeparator(String initialString) {
//      "//" 뒤에 문자 하나만 오는지 확인
        return initialString.charAt(2);
    }

}
