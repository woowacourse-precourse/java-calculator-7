package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 입력
        // 문자열 str 입력받음
        System.out.println("덧셈할 문자열을 입력해 주세요.\n");
        String str = Console.readLine();

        // 커스텀 구분자 찾기

        ArrayList<String> nums = new ArrayList<>();
        nums.add("1");
        nums.add("2");
        nums.add("3");

        // 잘못된 문자열인지 오류 탐색 or 합 출력
        int cnt = 0;

        for (String num : nums) {
            cnt += parserCheck.parserOrThrow(num);
        }

        System.out.println("결과 : " + cnt);

    }
}
