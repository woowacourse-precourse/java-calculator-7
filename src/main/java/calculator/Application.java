package calculator;

import calculator.entity.IndexQueue;
import calculator.entity.NumList;
import calculator.entity.SeparatorSet;
import calculator.service.SeparatorService;
import calculator.service.impl.SeparatorServiceImpl;
import camp.nextstep.edu.missionutils.Console;

public class Application {


    public static void main(String[] args) {

        SeparatorService separatorService = new SeparatorServiceImpl();

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        SeparatorSet customSeparators = separatorService.getCustomSeparators(input);
        String allSeparators = customSeparators.toRegexString();

        IndexQueue idxQueue = separatorService.getAllCustomSepIdx(input);
        String refineString = separatorService.refineString(input, idxQueue);

        NumList numList = separatorService.separateNum(refineString, allSeparators);
        int total = numList.sum();

        System.out.println("결과 : " + total);

    }
}
