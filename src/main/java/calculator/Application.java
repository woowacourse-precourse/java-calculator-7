package calculator;

import static calculator.Message.PROGRAM_OUTPUT_FORMAT;
import static calculator.Message.SUM_RESULT_FORMAT;
import static calculator.Message.USER_INPUT_PROMPT_MSG;
import static camp.nextstep.edu.missionutils.Console.readLine;

import calculator.myParser.MyParser;
import java.text.DecimalFormat;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println(USER_INPUT_PROMPT_MSG);
        String userInput = readLine();

//        Parser parser = new SimpleParser();
        Parser parser = new MyParser();
        List<Double> numbers = parser.parse(userInput);

        double sum = numbers.stream().mapToDouble(Double::doubleValue).sum();
        DecimalFormat decimalFormat = new DecimalFormat(SUM_RESULT_FORMAT);
        System.out.printf(PROGRAM_OUTPUT_FORMAT, decimalFormat.format(sum));
    }
}
