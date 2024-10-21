package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private static final List<Integer> numbers;

    static {
        numbers = new ArrayList<>();
    }

    /*
    * 매개변수를 객체 단위로 남길지, 그 안에 세부적인 값 형태로 넘길지 고민
    * */
    public static void run(String stringNumbers, String regularExpression) {
        String[] numberWords = stringNumbers.split(regularExpression);
        try {
            for (String numberWord : numberWords) {
                int num = Integer.parseInt(numberWord);
                if (num < 0)
                    throw new IllegalArgumentException("음수는 올 수 없습니다");
                Calculator.numbers.add(num);
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("잘못된 문자열 정수 입니다");
        } catch (Exception e) {
            System.out.println("예기치 않은 문제가 발생했습니다. 해결해야 합니다");
        }
    }

    public static int result() {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }
}
