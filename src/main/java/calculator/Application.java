package calculator;

import java.util.NoSuchElementException;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input;
        input = Console.readLine();
        int result = add(input); // 숫자 더하는 함수
        System.out.println("결과 : " + result);
}
