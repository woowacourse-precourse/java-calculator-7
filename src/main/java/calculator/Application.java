package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = Console.readLine();

        // 입력이 비어있을 경우 0출력
        if(input.isEmpty()){
            System.out.println("결과:"+0);
            return;
        }

    }
}
