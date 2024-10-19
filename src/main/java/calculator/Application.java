package calculator;

import calculator.input.InputData;
import calculator.parsing.ListChecker;
import calculator.parsing.ListParser;
import calculator.adder.ListAdder;
import calculator.output.OutputData;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = InputData.getInput();
        ListChecker delimiter = new ListChecker();
        delimiter.checkDelimeter(input);
        List<String> delimiterInput = delimiter.delimiters;
        String numbers = delimiter.numbers;
        System.out.println("delimiter: " + delimiterInput);
        System.out.println("numbers: " + numbers);
        List<Integer> numList = ListParser.parseList(numbers, delimiterInput);
        System.out.println("numberList: " + numList);
        int sum = ListAdder.sumData(numList);
        OutputData.Printout(sum);
    }
}
