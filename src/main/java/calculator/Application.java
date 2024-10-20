package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.lang.IllegalArgumentException;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        try {
            int sum = 0;

            if (input.startsWith("//")) { // 1. 커스텀 구분자 사용할 경우
                String[] A = input.split("\\\\n");
                String[] delimiter = A[0].substring(2).split("");

                String regex = String.join("|", delimiter);

                String[] numbers = A[1].split(regex);
                for (String i : numbers) {
                    int number = parseNumber(i);
                    sum += number;
                }
            } else { // 2. 일반 구분자(, or :) 사용할 경우
                String[] a = input.split("[,:]");

                for (String i : a) {
                    int number = parseNumber(i);
                    sum += number;
                }
            }
            System.out.println("결과 : " + sum);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    public static int parseNumber(String S) {
        try {
            int number = Integer.parseInt(S.trim());
            if (number < 0) {
                throw new IllegalArgumentException("양수가 아닙니다: " + number);
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다: " + S);
        }
    }
}
