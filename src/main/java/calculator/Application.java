package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class Application {
    public static void main(String[] args) {
        String input = null;
        try {
            input = Console.readLine();  // 사용자로부터 입력 받음
        } catch (NoSuchElementException e) {
            input = "";  // 입력이 없으면 빈 문자열로 처리
        }

        // 빈 문자열을 처리하는 부분
        if (input == null || input.isEmpty()) {
            System.out.println("결과 : 0");  // 빈 문자열이 입력되면 0 출력
            return;
        }


    }
}
