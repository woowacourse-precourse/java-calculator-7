package calculator;

import calculator.delimiter.CustomDelimiterDetector;
import calculator.operation.addOperator;
import calculator.parser.Seperator;
import calculator.parser.Splitter;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {

    private static final Splitter splitter = new Splitter();
    private static final CustomDelimiterDetector customDelimiterDetector = new CustomDelimiterDetector();
    private static final Seperator seperator = new Seperator();
    private static final addOperator addOperator = new addOperator();

    public static void main(String[] args) {
        try{
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = Console.readLine();

            String customDelimiter = customDelimiterDetector.findCustomDelimiter(input);
            input = customDelimiterDetector.removeCustomDelimiter(input, customDelimiter);
            seperator.addSeperator(customDelimiter);

            splitter.setSeperator(seperator);
            splitter.split(input);
            List<Integer> splitInput = splitter.split(input);

            int result = addOperator.operate(splitInput);

            System.out.println("결과 : " + result);
        } catch(NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }
}
