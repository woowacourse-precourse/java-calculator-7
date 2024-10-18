package calculator.domain.calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Calculator {

    private final Delimiter delimiter;

    private String inputStr;
    private ArrayList<Integer> numberList = new ArrayList<>();
    private Integer result = 0;

    public Calculator(Delimiter delimiter) {
        this.delimiter = delimiter;
    }

    public void plusOperation() {
        this.getString();
        this.extractNumberList();
        this.plusCalculate();
        this.printResult();
    }

    private void getString() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String s = Console.readLine();
        Console.close();

        if (s.length() >= 5 && s.charAt(0) == '/' && s.charAt(1) == '/'
                && s.charAt(3) == '\\' && s.charAt(4) == 'n') {
            if (Character.isDigit(s.charAt(2))) {
                throw new IllegalArgumentException();
            }
            delimiter.addDelimiter(s.charAt(2));
            s = s.substring(5);
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!(Character.isDigit(ch) || delimiter.isDelimiter(ch))) {
                throw new IllegalArgumentException();
            }
        }
        this.inputStr = s;
    }

    private void extractNumberList() {
        int num = 0;
        for (char ch : this.inputStr.toCharArray()) {
            if (delimiter.isDelimiter(ch)) {
                numberList.add(num);
                num = 0;
            } else {
                num *= 10;
                num += (ch - '0');
                if (num >= CalculatorConstant.LIMIT_NUMBER) {
                    throw new IllegalArgumentException();
                }
            }
        }
        numberList.add(num);
    }

    private void plusCalculate() {
        for (Integer number : numberList) {
            result += number;
            if (result >= CalculatorConstant.LIMIT_NUMBER) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void printResult() {
        System.out.println("결과 : " + result);
    }
}
