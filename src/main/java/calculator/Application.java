package calculator;

import adder.Adder;
import camp.nextstep.edu.missionutils.Console;
import separator.Separator;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        Adder adder = new Adder();
        Separator separator = new Separator();

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        String calculatorFormula = input;
        // 구분자 추출
        if(separator.validateCustomSeparatorForParsing(input)){
            Character customSeparator = separator.parseCustomSeparator(input);
            separator.addNewSeparator(customSeparator);

            calculatorFormula = separator.parseString(input);
        }

        // 계산 시작
        ArrayList<String> parsedCalculatorFormula = adder.parseStringWithSeparators(calculatorFormula);
        System.out.println("parsedCalculatorFormula = " + parsedCalculatorFormula);

        if(!adder.isValidated(parsedCalculatorFormula)){
            throw new IllegalArgumentException();
        }

        ArrayList<Integer> numbers = adder.parseOnlyNumbers(parsedCalculatorFormula);
        if(!adder.isAllPositiveInteger(numbers)){
            throw new IllegalArgumentException();
        }

        int result = adder.addNumbers(numbers);

        System.out.println("결과 : " + result);

    }
}
