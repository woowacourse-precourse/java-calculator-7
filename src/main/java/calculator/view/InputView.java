package calculator.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static List<Integer> inputString() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = readLine();
        // TODO: 구분자 분리 메소드 구현 후 호출
        List<Integer> list = new ArrayList<>();
        return list;
    }
}
