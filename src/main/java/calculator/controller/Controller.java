package calculator.controller;

import calculator.model.Calculator;
import calculator.model.Tokenizer;
import calculator.view.View;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Controller {
    private final Tokenizer tokenizer;
    private final Calculator calculator;
    private final View view;

    public Controller(Tokenizer tokenizer, Calculator calculator, View view) {
        this.tokenizer = tokenizer;
        this.calculator = calculator;
        this.view = view;
    }

    public void service() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String input = Console.readLine();
        List<Integer> integerList = inputValidate(input);
        int sumResult = calculator.sum(integerList);

        view.print(sumResult);
        Console.close();
    }

    private List<Integer> inputValidate(String input) {
        if(input.isBlank()) {
            return List.of(0);
        }

        List<String> inputList = tokenizer.tokenize(input);

        try {
            return inputList.stream()
                    .map(Integer::valueOf)
                    .toList();
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }


}
