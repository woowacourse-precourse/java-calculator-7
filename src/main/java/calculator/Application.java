package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        StringSplitter splitter = new StringSplitter();
        List<String> splitStringList = splitter.split(input);

        StringIntegerConverter converter = new StringIntegerConverter();

        List<Integer> numberList;
        try {
            numberList = converter.convert(splitStringList);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }

        int sum = numberList.stream().mapToInt(Integer::intValue).sum();

        System.out.println("결과 : " + sum);
        Console.close();
    }
}
