package calculator;

import calculator.adder.ListAdder;
import calculator.input.InputData;
import calculator.output.OutputData;
import calculator.parsing.ListChecker;
import calculator.parsing.ListParser;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = InputData.getInput();
        ListChecker delimiter = new ListChecker();
        List<String> delimiterInput = delimiter.getDelimiters(input);
        String numbers = delimiter.getNumbers();
        System.out.println("delimiter: " + delimiterInput);
        System.out.println("numbers: " + numbers);
        List<Integer> numList = ListParser.parseList(numbers, delimiterInput);
        System.out.println("numberList: " + numList);
        int sum = ListAdder.sumData(numList);
        OutputData.Printout(sum);
    }
}
