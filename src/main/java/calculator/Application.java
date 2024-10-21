package calculator;

import camp.nextstep.edu.missionutils.Console;
import constant.Constant;
import java.util.List;
import stringprocess.StringProcessorFacade;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        StringProcessorFacade stringProcessor = new StringProcessorFacade();

        Calculator calculator = new Calculator();

        //프로그램 시작
        System.out.println(Constant.START_APP);
        String input = Console.readLine();
        Console.close();

        if (input.isBlank()) {
            System.out.println(Constant.RESULT + 0);
            return;
        }

        //문자열 숫자로만 이루어진 리스트
        List<String> stringNumbers = stringProcessor.process(input);

        //합계산
        int sum = calculator.calculate(stringNumbers);

        System.out.println(Constant.RESULT + sum);
    }

}
