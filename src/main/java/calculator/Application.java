package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class Application {
    public static void main(String[] args) {
        try {
            // 입력 받기
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = Console.readLine();

            // 숫자 추출
            String[] numbers = Service.separate(input);

            // 숫자 배열의 합
            int result = Service.add(numbers);

            // 출력
            System.out.println("결과 : " + result);
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("입력이 없습니다.");
        }
    }
}
