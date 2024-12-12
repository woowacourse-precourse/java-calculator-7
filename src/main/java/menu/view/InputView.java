package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String RECOMMENDATION_START_MSG = "점심 메뉴 추천을 시작합니다.";
    private static final String COACH_NAME_INPUT_MSG = "코치의 이름을 입력해 주세요. (, 로 구분)";

    public List<String> readCoachs() {
        String input = Console.readLine();
        return parseCoachs(input.split(","));
    }

    private List<String> parseCoachs(String[] input) {
        List<String> coachs = new ArrayList<>();
        for (String coach : input) {
            coachs.add(coach);
        }
        return coachs;
    }
}
