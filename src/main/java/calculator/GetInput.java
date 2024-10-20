package calculator;

import camp.nextstep.edu.missionutils.Console;

public class GetInput {

    // 사용자의 입력을 받는 메서드
    static String input_String() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine().replace("\\n", "\n"); // 문자열에서 "\n"을 실제 줄바꿈 문자로 변환
    }
}
