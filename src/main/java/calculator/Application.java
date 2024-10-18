package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.text.DecimalFormat;
import java.util.List;

public class Application {
    public static final String USER_INPUT_PROMPT_MSG = "덧셈할 문자열을 입력해 주세요.";
    public static final String PROGRAM_OUTPUT_FORMAT = "결과 : %s\n";

    public static void main(String[] args) {
        System.out.println(USER_INPUT_PROMPT_MSG);
        String userInput = readLine();

        Parser parser = new SimpleParser();
        List<Double> numbers = parser.parse(userInput);

        double sum = numbers.stream().mapToDouble(Double::doubleValue).sum();
        DecimalFormat decimalFormat = new DecimalFormat("#.#####");
        System.out.printf(PROGRAM_OUTPUT_FORMAT, decimalFormat.format(sum));
    }
}
