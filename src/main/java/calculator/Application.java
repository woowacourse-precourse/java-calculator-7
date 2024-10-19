package calculator;

import java.math.BigInteger;
import java.util.Arrays;

import camp.nextstep.edu.missionutils.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        boolean isCustom = false;

        StringBuilder tempCustomString = new StringBuilder();
        String rest = input;

        for (int i = 0; i < input.length() - 1; i++) {
            if (!isCustom) {
                if (input.startsWith("//", i)) {
                    isCustom = true;
                    tempCustomString = new StringBuilder("//");
                    i++;
                }
            } else {
                if (input.startsWith("\\n", i)) {
                    isCustom = false;
                    tempCustomString.append(input, i, i + 2);
                    rest = rest.replace(tempCustomString, ":");
                    i++;
                } else {
                    tempCustomString.append(input.charAt(i));

                }
            }
        }

        if (isCustom) {
            throw new IllegalArgumentException("커스텀 구분자가 닫혀 있지 않습니다.");
        }

        String[] numbers = Arrays.stream(rest.split("[:,]")).map(String::trim)
                .filter(s -> !s.isEmpty())
                .toArray(String[]::new);

        if (numbers.length == 0) {
            throw new IllegalArgumentException("숫자가 없습니다.");
        }

        for (String number : numbers) {
            if (number.length() == 1 && number.charAt(0) == '0') {
                throw new IllegalArgumentException("0값은 올 수 없습니다.");
            }
            for (int i = 0; i < number.length(); i++) {
                if (!(number.charAt(i) >= '0' && number.charAt(i) <= '9')) {
                    throw new IllegalArgumentException("양수가 아니거나, 올바른 숫자가 아닙니다.");
                }
            }
        }


        String answer = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            System.out.println("numbers = " + numbers[i]);
            String nowNumber = numbers[i];

            answer = new BigInteger(answer).add(new BigInteger(nowNumber)).toString();
        }


        System.out.println("결과 : " + answer);
    }
}
