package calculator;

import java.util.List;

public class Application {


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Calculator calculator = new Calculator();
        // 입력받기
        String input = calculator.getInput();
        // 파싱하기
        List<Integer> numbers = calculator.parse(input);
        // 계산하기
        int result = calculator.add(numbers);
        // 출력하기
        System.out.println("결과 : " + result);
    }

}
