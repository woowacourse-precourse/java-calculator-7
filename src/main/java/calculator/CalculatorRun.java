package calculator;

import java.util.Arrays;
import java.util.List;
import util.InputUtil;
import util.MessageUtil;

public class CalculatorRun {

    private final InputUtil inputUtil = new InputUtil();
    private final MessageUtil messageUtil = new MessageUtil();


    public void run() {
        messageUtil.printStringForSum();

        List<Integer> integerList = getIntegerListInfo();
        Integer result = computeResult(integerList);

        messageUtil.printResult();
    }

    private List<Integer> getIntegerListInfo() {
        String initialString = inputUtil.userInput();
        List<Integer> integerList = splitInitialString(initialString);
        return integerList;
    }

    private List<Integer> splitInitialString(String initialString) {
        List<Character> seporators = Arrays.asList(',', ':');

        if (initialString.startsWith("//")) {
            seporators.add(setExtraSeparator(initialString));
            initialString = initialString.substring(5);
        }
//        for (Character c : seporators) {
//            String[] s = initialString.split(Character.toString(c));
//        }

        int startIndex = 0;
        int endIndex = 0;
        for (char c : initialString.toCharArray()) {
            if ((Character.isDigit(c))) {

            }
        }
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