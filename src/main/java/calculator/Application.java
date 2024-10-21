package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class Application {

    public static void main(String[] args) {

        // TODO: 프로그램 구현
        String inputString;

        try {
            inputString = Console.readLine(); // 입력 읽기
        } catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("결과 : 0");
            return;
        }

        // TODO: 문자열 파싱 객체에서 구분자, 숫자 받아오기
        Parser parser = Parser.getInstance();

        // TODO : calculate sum
        parser.parseNums(inputString);

        int sum = Calculator.calculateSum(parser.getNums());
        System.out.println("결과 : " + sum);
    }
}
