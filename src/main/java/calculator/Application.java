package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        Validator validator = new Validator();
        validator.validateInput(input);

        Delimiter delimiter = new Delimiter(input);
        Number number = new Number(input);

        Set<String> delimiters = delimiter.getDelimiters();
        List<Integer> numbers = number.getNumbers();

        validator.validateDelimeters(delimiters);
        validator.validateNumbers(numbers);

        System.out.println("결과 : " + number.calculateTotal());
    }
}
