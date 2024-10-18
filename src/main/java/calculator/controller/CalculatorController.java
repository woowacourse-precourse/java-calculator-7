package calculator.controller;

import calculator.domain.Calculator;
import calculator.util.Validator;
import calculator.view.CalculatorView;

public class CalculatorController {

    private final Calculator calculator;
    private final CalculatorView view;
    private final Validator validator;

    public CalculatorController(Calculator calculator, CalculatorView view) {
        this.calculator = new Calculator();
        this.view = new CalculatorView();
        this.validator = new Validator();
    }

    public void run(){
        String input = view.getInput();
        processInput(input);
        int result = calculator.calculate();
        view.getResult(result);
    }

    private void processInput(String input) {
        // 문자열 검사 및 계산기 인스턴스 업데이트
        int index = 0;
        for(int i = 0; i < input.length(); i++) {
            String letter = String.valueOf(input.charAt(i));
            if(!isInteger(letter)){
                if(letter.equals("/") && !calculator.getSeperators().contains(letter)){
                    // 구분자 등록 전에 숫자가 있는 경우 숫자 추가
                    if(i != 0){
                        String number = input.substring(index, i);
                        addNumber(number);
                    }
                    // 구분자 추가 등록
                    String seperators = findSeperators(i, input);
                    addSeperators(seperators);
                    i += seperators.length() + 3;
                    index = i + 1;
                } else {
                    // 구분자 이전의 숫자 등록
                    validator.validateRegisteredSeperator(calculator, letter);
                    String number = input.substring(index, i);
                    addNumber(number);
                    index = i + 1;
                }
            }
        }

        // 문자열에서 마지막 숫자 추가
        String lastNumber = input.substring(index);
        if(isInteger(lastNumber)){
            addNumber(lastNumber);
        }
    }

    private void addNumber(String number) {
        validator.validateNumber(number);
        calculator.addNumber(number);
    }

    // 커스텀 구분자를 찾아서 반환
    private String findSeperators(int startIndex, String input) {
        validator.validateStartOfRegister(input.substring(startIndex, startIndex + 2));

        int endIndex = 1;
        for(int i = startIndex + 2; i < input.length(); i++) {
            char ch = input.charAt(i);
            if(String.valueOf(ch).equals("n")){
                endIndex = i;
                break;
            }
        }

        validator.validateEndOfRegister(input.substring(endIndex-1, endIndex + 1));
        return input.substring(startIndex+2, endIndex-1);
    }

    // 계산기 인스턴스에 커스텀 구분자 추가
    private void addSeperators(String seperators) {
        for(int i = 0; i < seperators.length(); i++) {
            char ch = seperators.charAt(i);
            validator.validateNewSeperator(String.valueOf(ch));
            calculator.addSeperator(String.valueOf(ch));
        }
    }

    // 숫자가 올바른 형식인지 검사
    private static boolean isInteger(String letter) {
        try {
            Integer.parseInt(letter);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
