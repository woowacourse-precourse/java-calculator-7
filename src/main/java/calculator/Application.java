package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Separator separator = new Separator();
        Number number = new Number();
        Adder adder = new Adder();

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        if(input.isEmpty()){
            System.out.println("결과 : 0");
            return;
        }

        String processedString = separator.addCustomParser(input);
        number.extractNumbers(processedString, separator.createDelimiterRegex());
        adder.sumNumbers(number.getExtractedNumbers());
    }
}
