package calculator;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        // 계산기 인스턴스 생성
        Calculator calculator = new Calculator();

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
                    if(calculator.seperators.contains(letter)){
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

        // 계산 진행
        int result = calculator.calculate();

        System.out.println("결과 : " + result);
    }

    private static void addNumber(Calculator calculator, String number) {
        if(isInteger(number)){
            if(Integer.parseInt(number) > 0){
                calculator.addNumber(number);
            } else {
                throw new IllegalArgumentException("입력된 숫자가 음수입니다.");
            }
        } else {
            throw new IllegalArgumentException("올바르지 않은 숫자 형식입니다.");
        }
    }

    private static boolean isInteger(String letter) {
        try {
            Integer.parseInt(letter);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

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

    private static void addSeperators(Calculator calculator, String seperators) {
        for(int i = 0; i < seperators.length(); i++) {
            char ch = seperators.charAt(i);
            calculator.addSeperator(String.valueOf(ch));
        }
    }

    // 계산기 클래스 정의
    private static class Calculator {

        private ArrayList<Integer> numbers;
        private Set<String> seperators;
        private int result;

        private Calculator() {
            numbers = new ArrayList<>();
            seperators = new HashSet<>();
            result = 0;
            seperators.add(",");
            seperators.add(":");
        }

        private void addNumber(String number) {
            numbers.add(Integer.parseInt(number));
        }

        private void addSeperator(String seperator) {
            seperators.add(seperator);
        }

        private int calculate() {
            for(int number : numbers) {
                result += number;
            }
            return result;
        }
    }

}

