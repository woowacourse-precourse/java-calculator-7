package calculator.controller;

import calculator.util.InputUtil;
import calculator.util.MessageUtil;
import java.util.ArrayList;
import java.util.List;

public class CalculatorController {

    private final InputUtil inputUtil = new InputUtil();
    private final MessageUtil messageUtil = new MessageUtil();


    public void run() {
        messageUtil.printStringForSum();

        List<Integer> integerList = getIntegerListInfo();
        Integer result = computeResult(integerList);

        messageUtil.printResult(result);
    }

    private List<Integer> getIntegerListInfo() {
        String initialInput = inputUtil.userInput();
        boolean isValidInputType = isValidInput(initialInput);
        if (!isValidInputType) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다.");
        }
        List<Integer> integerList = splitInitialString(initialInput);
        return integerList;
    }

    boolean isValidInput(String initialInput) {
        if (initialInput == null || initialInput.isEmpty()) {
            return false;
        }
        return initialInput.startsWith("//") || Character.isDigit(initialInput.charAt(0));
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
            boolean isValidNumberType = isValidNumber(s);
            if (!isValidNumberType) {
                throw new IllegalArgumentException("유효하지 않은 입력입니당.");
            }
            integerList.add(Integer.valueOf(s));
        }
        return integerList;

    }

    private boolean isValidNumber(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        return Character.isDigit(s.charAt(0));
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