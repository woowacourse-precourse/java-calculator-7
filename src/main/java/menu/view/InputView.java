package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String COACH_NAME_INPUT_MSG = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String INEDIBLE_MENU_INPUT_MSG = "\n%s(이)가 못 먹는 메뉴를 입력해 주세요.\n";

    public List<String> readCoachs() {
        System.out.println(COACH_NAME_INPUT_MSG);
        String input = Console.readLine();
        return parseInput(input.split(","));
    }

    public List<String> readInedibles(String coach) {
        System.out.printf(INEDIBLE_MENU_INPUT_MSG, coach);
        String input = Console.readLine();
        return parseInput(input.split(","));
    }

    private List<String> parseInput(String[] input) {
        List<String> listInput = new ArrayList<>();
        for (String s : input) {
            listInput.add(s);
        }
        return listInput;
    }
}
