package calculator.integration;

import calculator.adder.ListAdder;
import calculator.input.InputData;
import calculator.output.OutputData;
import calculator.parsing.ListChecker;
import calculator.parsing.ListParser;
import java.util.List;

public class Viewer {
    private Viewer() {
    }

    public static void view() {
        String input = InputData.getInput();
        ListChecker delimiter = new ListChecker();

        List<String> delimiterInput = getDelimiterInput(delimiter, input);

        String numbers = getNumbersInput(delimiter);

        List<Integer> numList = ListParser.parseList(numbers, delimiterInput);

        int sum = ListAdder.sumData(numList);

        OutputData.Printout(sum);
    }

    private static List<String> getDelimiterInput(ListChecker delimiter, String input) {
        return delimiter.getDelimiters(input);
    }

    private static String getNumbersInput(ListChecker delimiter) {
        return delimiter.getNumbers();
    }
}