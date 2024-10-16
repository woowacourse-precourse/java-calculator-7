package calculator;

import java.util.ArrayList;
import java.util.HashMap;
import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.Set;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        // 계산기 인스턴스 생성
        Calculator calculator = new Calculator();

        // 입력을 토대로 숫자 추가
        calculator.addNumbers(input);

        // 계산 진행
        calculator.calculate();

        System.out.println("결과 : " + calculator.result);
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

        public void addNumbers(String input) {
            int index = 0;
            for(int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if(seperators.contains(String.valueOf(ch))) {
                    String number = input.substring(index, i);
                    numbers.add(Integer.parseInt(number));
                    index = i + 1;
                }
            }
            String number = input.substring(index, input.length());
            numbers.add(Integer.parseInt(number));
        }

        public void calculate() {
            for(int number : numbers) {
                result += number;
            }
        }
    }

}

