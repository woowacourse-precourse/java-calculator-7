package calculator;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;


public class FindNum {
    public List<Integer> FNumber(String string, String d) {
        String[] numbers = string.split(d);
        List<Integer> result = new ArrayList<>();
        for (String number : numbers) {
            if (number.isEmpty()) {
                continue;
            }

            try {
                int num = Integer.parseInt(number.trim());
                if (num > 0) {
                    result.add(num);
                }
            } catch (NumberFormatException e) {

            }
        }

        return result;  // 양수 리스트 반환
    }
}

public class Calculate{
    public int result(){

    }

}



public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String string = Console.readLine();

        String del = ",|/|:";

        FindNum numberExtractor = new FindNum();

        List<Integer> numbers = numberExtractor.FNumber(string, del);
        Calculate calculator = new Calculate();
        int sum = calculator.result(numbers);
        System.out.println("합계: " + sum);

    }
}

