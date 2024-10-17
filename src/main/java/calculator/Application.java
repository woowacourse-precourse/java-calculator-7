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

        // 구분자 등록
        ArrayList<String> seperators = findSeperators(input);
        input = modifyInput(seperators, input);
        for(String seperator : seperators) {
            calculator.addSeperator(seperator);
        }
        
        // 입력을 토대로 숫자 추가
        calculator.addNumbers(input);
        // 계산 진행
        calculator.calculate();

        System.out.println("결과 : " + calculator.getResult());
    }

    private static ArrayList<String> findSeperators(String input) {
        ArrayList<String> seperators = new ArrayList<>();

        if(String.valueOf(input.charAt(0)).equals("/")){
            for(int i = 2; i < input.length(); i++) {
                if(String.valueOf(input.charAt(i)).equals("\\")) break;
                seperators.add(String.valueOf(input.charAt(i)));
            }
        }
        return seperators;
    }

    private static String modifyInput(ArrayList<String> seperators, String input) {
        int start = seperators.size() + 4;
        return input.substring(start);
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

        private void addNumbers(String input) {
            int index = 0;
            for(int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if(seperators.contains(String.valueOf(ch))) {
                    String number = input.substring(index, i);
                    addNumber(number);
                    index = i + 1;
                }
            }
            addNumber(input.substring(index));
        }

        private void addNumber(String number) {
            try{
                numbers.add(Integer.parseInt(number));
            } catch(NumberFormatException e) {
                System.out.println("유효하지 않은 숫자: " + number);
            }
        }

        private void addSeperator(String seperator) {
            seperators.add(seperator);
        }

        private void calculate() {
            for(int number : numbers) {
                result += number;
            }
        }

        private int getResult() {
            return result;
        }
    }

}

