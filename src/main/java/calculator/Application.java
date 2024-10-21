package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Delimiter delimiter = new Delimiter();
        NumberSplitter numberSplitter = new NumberSplitter();
        Calculator calculator = new Calculator();

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();

        if (str.isEmpty()) {
            System.out.print("결과 : 0");
            return;
        }

        str = delimiter.setDelimiters(str);

        if (str.isEmpty()) {
            return;
        }

        String splitDelimiters = delimiter.makeSplitDelimiters();
        numberSplitter.setSeparatedNumbers(str, splitDelimiters);
        calculator.setResult(numberSplitter.getSeparatedNumbers());
    }
}