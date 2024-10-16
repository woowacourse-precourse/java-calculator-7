package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String str = Console.readLine();

    }

    //숫자 추출함수
    public static List<Integer> extractNumbers(String str, List<Character> separatorList) {
        List<Integer> numberList = new ArrayList<>();

        if (str.isEmpty()) {
            numberList.add(0);
        } else {
            StringBuilder regexBuilder = new StringBuilder();
            regexBuilder.append("[");

            for (Character character : separatorList) {
                regexBuilder.append(character);
            }
            regexBuilder.append("]");

            String[] parts = str.split(regexBuilder.toString());
            for (String part : parts) {
                if (!part.isEmpty()) {
                    try {
                        int number = Integer.parseInt(part);
                        numberList.add(number);
                    } catch (NumberFormatException e) {
                        System.out.println("잘못된 입력 : " + part);
                    }
                }
            }
        }
        return numberList;
    }

    public static long sumNumbers(List<Integer> numberList) {
        long sum = 0;
        for (Integer i : numberList) {
            sum += i;
        }
        return sum;
    }
}
