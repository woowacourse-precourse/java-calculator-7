package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private final List<Integer> numbers = new ArrayList<>();

    public void run(String inputWord, Division division) {
        String[] numberWords = inputWord.split(division.regularExpression());
        try {
            for (String numberWord : numberWords) {
                numbers.add(Integer.parseInt(numberWord));
            }
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 문자열 정수 입니다");

        } catch (Exception e) {
            System.out.println("예기치 않은 문제가 발생했습니다. 해결해야 합니다");
        }
    }

    public int result() {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }
}
