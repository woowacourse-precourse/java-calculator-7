package calculator;

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
        List<Integer> integerList = splitInitialString();
        return integerList;
    }

    private Integer computeResult(List<Integer> integerList) {
        Integer result = 0;
        for (Integer num : integerList) {
            result += num;
        }
        return result;
    }
}