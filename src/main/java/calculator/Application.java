package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

class FindNum {
    public List<Integer> fNumber(String string, String d) {
        if (string.isEmpty()) {
            return List.of(0);  // 빈 문자열 처리
        }
        String[] numbers = string.split(d);
        List<Integer> result = new ArrayList<>();
        for (String number : numbers) {
            if (number.isEmpty()) {
                continue;
            }
            try {
                int num = Integer.parseInt(number.trim());
                if (num < 0) {
                    throw new IllegalArgumentException("IllegalArgumentException" + num);
                }
                result.add(num);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("IllegalArgumentException" + number);
            }
        }
        return result;
    }
}


class Calculate {
    // 숫자 리스트의 합을 계산하는 메서드
    public int result(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }
}

class FindCustomDel {
    public String Fcustomdel(String b) {
        if (b.startsWith("//")) {
            return Character.toString(b.charAt(2));
        }
        return ",|:|/";
    }
    public String extract_Number(String b) {
        if (b.startsWith("//")) {
            return b.substring(4);
        }
        return b;
    }
}

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine(); //문자열 입력

        FindCustomDel customDel = new FindCustomDel();
        String delimiter = customDel.Fcustomdel(input);
        String numbersPart = customDel.extract_Number(input);

        FindNum numberExtractor = new FindNum();
        List<Integer> numbers = numberExtractor.fNumber(numbersPart, delimiter);

        Calculate calculator = new Calculate();
        int sum = calculator.result(numbers);

        System.out.println("합계: " + sum);
    }
}
