package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import menu.util.Parser;
import menu.util.Spliter;
import menu.util.Validator;

public class InputView {
    private static final String INPUT_COACH_MSG = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String INPUT_INEDIBLE = "\n%s(이)가 못 먹는 메뉴를 입력해 주세요.\n";

    public List<String> readCoach() {
        while (true) {
            try {
                System.out.println(INPUT_COACH_MSG);
                String input = Console.readLine();
                String[] splitInput = Spliter.splitInput(input);
                Validator.validateCoach(splitInput);
                return Parser.parseInputToList(splitInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<String> readInedible(String name) {
        while (true) {
            try {
                System.out.printf(INPUT_INEDIBLE, name);
                String input = Console.readLine();
                String[] splitInput = Spliter.splitInput(input);
                Validator.validateInedible(splitInput);
                return Parser.parseInputToList(splitInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
