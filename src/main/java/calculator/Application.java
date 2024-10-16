package calculator;

import calculator.entity.IndexQueue;
import calculator.entity.Input;
import calculator.entity.NumList;
import calculator.entity.RefinedInput;
import calculator.entity.RegexStr;
import calculator.entity.SeparatorSet;
import calculator.service.SeparatorService;
import calculator.service.impl.SeparatorServiceImpl;
import camp.nextstep.edu.missionutils.Console;

public class Application {


    public static void main(String[] args) {

        SeparatorService separatorService = new SeparatorServiceImpl();

        System.out.println("덧셈할 문자열을 입력해 주세요.");

        Input input = new Input(Console.readLine());

        SeparatorSet customSeparators = separatorService.getCustomSeparators(input);
        RegexStr regexStr = customSeparators.toRegexStr();

        IndexQueue idxQueue = separatorService.getAllCustomSepIdx(input);
        RefinedInput refinedInput = separatorService.refineInput(input, idxQueue);

        NumList numList = separatorService.separateNum(refinedInput, regexStr);
        int total = numList.sum();

        System.out.println("결과 : " + total);

    }
}
