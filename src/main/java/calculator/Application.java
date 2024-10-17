package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

class FindNum {
    public List<Integer> FNumber(String string, String d) {
        String[] numbers = string.split(d);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i].isEmpty()) {
                continue;
            }

            try {
                int num = Integer.parseInt(numbers[i].trim());
                if (num > 0) {
                    result.add(num);
                }
            } catch (NumberFormatException e) {
                System.out.println("IllegalArgumentException");
            }
        }

        return result;  // 양수 리스트 반환
    }
}

class Calculate {
    // 숫자 리스트의 합을 계산하는 메서드
    public int result(List<Integer> numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }
        return sum;
    }
}

class FindCustomDel {

}

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine(); //문자열 입력

        FindNum numberExtractor = new FindNum();
        List<Integer> numbers = numberExtractor.FNumber(numbersPart, delimiter);

        Calculate calculator = new Calculate();
        int sum = calculator.result(numbers);

        System.out.println("합계: " + sum);
    }
}
