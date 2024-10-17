package calculator.controller;

import calculator.domain.Calculator;
import calculator.view.CalculatorView;

public class CalculatorController {

    private Calculator calculator;
    private CalculatorView view;

    public CalculatorController(Calculator calculator, CalculatorView view) {
        this.calculator = calculator;
        this.view = view;
    }

    public void run(){
        try {
            String input = view.getInput();
            processInput(input);
            int result = calculator.calculate();
            view.getResult(result);
        } catch (Exception e) {
            view.getError(e.getMessage());
        }
    }

    private void processInput(String input) {
        // 문자열 검사 및 계산기 인스턴스 업데이트
        int index = 0;
        for(int i = 0; i < input.length(); i++) {
            String letter = String.valueOf(input.charAt(i));

            if(!isInteger(letter)){
                // 구분자 추가 등록
                if(letter.equals("/")){
                    if(i != 0){
                        String number = input.substring(index, i);
                        addNumber(calculator, number);
                    }
                    String seperators = findSeperators(i, input);
                    addSeperators(calculator, seperators);
                    i += seperators.length() + 3;
                    index = i + 1;
                } else {
                    // 구분자 이전의 숫자 등록
                    if(calculator.getSeperators().contains(letter)){
                        String number = input.substring(index, i);
                        addNumber(calculator, number);
                        index = i + 1;
                    } else {
                        throw new IllegalArgumentException("등록되지 않은 구분자입니다." + letter);
                    }
                }
            }
        }

        // 문자열에서 마지막 숫자 추가
        String lastNumber = input.substring(index);
        if(isInteger(lastNumber)){
            addNumber(calculator, lastNumber);
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

    // 커스텀 구분자를 찾아서 반환
    private static String findSeperators(int startIndex, String input) {
        if(!input.substring(startIndex, startIndex + 2).equals("//")){
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        int endIndex = 0;
        for(int i = startIndex + 2; i < input.length(); i++) {
            char ch = input.charAt(i);
            if(String.valueOf(ch).equals("n")){
                endIndex = i;
                break;
            }
        }

        if(!input.substring(endIndex-1, endIndex + 1).equals("\\n")){
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        return input.substring(startIndex+2, endIndex-1);
    }

    // 계산기 인스턴스에 커스텀 구분자 추가
    private static void addSeperators(Calculator calculator, String seperators) {
        for(int i = 0; i < seperators.length(); i++) {
            char ch = seperators.charAt(i);
            calculator.addSeperator(String.valueOf(ch));
        }
    }

    // 계산기 인스턴스에 숫자 추가
    private static void addNumber(Calculator calculator, String number) {
        if(isInteger(number)){
            if(Integer.parseInt(number) >= 0){
                calculator.addNumber(number);
            } else {
                throw new IllegalArgumentException("입력된 숫자가 음수입니다.");
            }
        } else {
            throw new IllegalArgumentException("올바르지 않은 숫자 형식입니다.");
        }
    }

}
