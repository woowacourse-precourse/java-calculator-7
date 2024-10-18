package calculator.controller;

import calculator.util.InputUtil;
import calculator.util.MessageUtil;
import calculator.util.ValidationUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculatorController {

    private final InputUtil inputUtil = new InputUtil();
    private final MessageUtil messageUtil = new MessageUtil();
    private final ValidationUtil validationUtil = new ValidationUtil();


    public void run() {
        messageUtil.printStringForSum();

        List<Integer> integerList = getIntegerListInfo();
        Integer result = computeResult(integerList);

        messageUtil.printResult(result);
    }

    private List<Integer> getIntegerListInfo() {
        String initialInput = inputUtil.userInput();

        if (initialInput == null || initialInput.isEmpty()) {
            return Arrays.asList(0);
        }

        validationUtil.isValidInput(initialInput);

        return splitInitialString(initialInput);
    }


    private List<Integer> splitInitialString(String initialString) {
        String seporators = ",|:";

//        !@#$%^&* 특수문자 고려
        if (initialString.startsWith("//")) {
            seporators = seporators + "|" + setExtraSeparator(initialString);
            initialString = initialString.substring(5);
        }
        System.out.println(seporators);
//        for (Character c : seporators) {
////            구분자 어떻게 처리할건지...
//            String[] s = initialString.split(Character.toString(c));
//        }

        String[] numList = initialString.split(seporators);
        List<Integer> integerList = new ArrayList<>();

        for (String s : numList) {
            validationUtil.isValidNumber(s);
            if (s.isEmpty()) {
                integerList.add(0);
                System.out.println(Integer.valueOf(s));
                continue;
            }
            integerList.add(Integer.valueOf(s));
            System.out.println(Integer.valueOf(s));
        }
        return integerList;

    }


    private Character setExtraSeparator(String initialString) {
//      "//" 뒤에 문자 하나만 오는지 확인
        return initialString.charAt(2);
    }

    private Integer computeResult(List<Integer> integerList) {
        Integer result = 0;
        for (Integer num : integerList) {
            result += num;
        }
        return result;
    }
}