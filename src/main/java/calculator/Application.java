package calculator;

import calculator.input.InputData;
import calculator.parsing.ListChecking;
import calculator.parsing.ListParsing;
import calculator.adder.DataSumming;
import calculator.output.OutputData;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = InputData.getInput();
        ListChecking delimiter = new ListChecking();
        delimiter.checkDelimeter(input);
        List<String> delimiterInput = delimiter.delimiters;
        String numbers = delimiter.numbers;
        System.out.println("delimiter: " + delimiterInput);
        System.out.println("numbers: " + numbers);
        List<Integer> numList = ListParsing.parseList(numbers, delimiterInput);
        System.out.println("numberList: " + numList);
        int sum = DataSumming.sumData(numList);
        OutputData.Printout(sum);
    }
}
