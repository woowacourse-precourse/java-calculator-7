package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

class FindNum {
    public List<Integer> fNumber(String input, String delimiter) {
        List<Integer> result = new ArrayList<>();
        StringBuilder currentNumber = new StringBuilder(); // 숫자를 일시적으로 저장할 공간
        boolean hasInvalidChar = false;
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (currentChar == 'd') {
                currentNumber.append('0');
            }
            else if (Character.isDigit(currentChar)) {
                currentNumber.append(currentChar);
            }
            else if (delimiter.indexOf(currentChar) >= 0) {
                if (currentNumber.length() > 0) {
                    int num = Integer.parseInt(currentNumber.toString());
                    if (num < 0) {
                        throw new IllegalArgumentException("음수 " + num);
                    }
                    result.add(num);
                    currentNumber.setLength(0); // 숫자 초기화
                }
            }
            else {
                hasInvalidChar = true;
            }
        }
        if (currentNumber.length() > 0) {
            int num = Integer.parseInt(currentNumber.toString());
            if (num < 0) {
                throw new IllegalArgumentException("음수 " + num);
            }
            result.add(num);
        }
        if (hasInvalidChar) {
            throw new IllegalArgumentException("허용되지 않은 문자가 포함되었습니다."+currentNumber);
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
        if (b.charAt(0) == '/' && b.charAt(1) == '/') {
            char a =  b.charAt(2);
            return Character.toString(a);
        }
        return ",|:";
    }
    public String extract_Number(String b) {
        if (b.charAt(0) == '/' && b.charAt(1) == '/') {
            return b.substring(b.indexOf('\n') + 1);
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