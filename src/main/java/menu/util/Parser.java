package menu.util;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    public static List<String> parseInputToList(String[] splitInput) {
        List<String> list = new ArrayList<>();
        for (String input : splitInput) {
            list.add(input);
        }
        return list;
    }
}
