package calculator;

import Factory.SeparatorFactory;
import camp.nextstep.edu.missionutils.Console;
import separator.CustomSeparatorFormat;
import view.InputGuidelines;

import java.util.List;

public class Application {

    //TODO 자바코드컨벤션 인텔리제이에 등록해놓기
    public static void main(String[] args) {
        List<String> defaultSeparators = List.of(",", ":");
        InputGuidelines inputGuidelines = new InputGuidelines(defaultSeparators);
        inputGuidelines.printInputGuidelines();
        SeparatorFactory separatorFactory = new SeparatorFactory(defaultSeparators,new CustomSeparatorFormat(),Console.readLine());

        Calculator calculator = new Calculator(separatorFactory.generateSeparators());
        System.out.println("결과 : "+calculator.run());
    }
}
