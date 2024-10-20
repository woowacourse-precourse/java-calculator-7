package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {
    private final InputValidator inputValidator;
    private final NumberSplitter numberSplitter;
    private final SumCalculator sumCalculator;

    public Calculator(InputValidator inputValidator, NumberSplitter numberSplitter, SumCalculator sumCalculator) {
        this.inputValidator = inputValidator;
        this.numberSplitter = numberSplitter;
        this.sumCalculator = sumCalculator;
    }

    private int processCalculation(String input){ // 주어진 입력문자열 처리하여 숫자의 합 반환.
        if(inputValidator.inputIsEmpty(input)){ // 입력이 "" 이면 0반환.
            return 0;
        }
        String[] validatedInput;

        validatedInput = inputValidator.validateAndPrepareInput(input); // 사용자 입력 유효성 검사 및 전처리

        String preparedInput = validatedInput[0]; // 유효성 검사 및 전처리 완료된 input
        String delimiters = validatedInput[1]; // 전처리 완료된 구분자
        String[] numbers = numberSplitter.splitNumbers(preparedInput, delimiters);
        return sumCalculator.calculateSum(numbers);
    }

    public void calculate(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        System.out.println("결과 : " + processCalculation(input));//문자열 입력받기.

    }
}
