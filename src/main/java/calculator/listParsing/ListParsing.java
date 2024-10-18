package calculator.listParsing;

import java.util.ArrayList;
import java.util.List;

public class ListParsing {
    private ListParsing() {

    }

    public static List<Integer> parseList(String input, List<String> delimiter) {

        String delimiterRegex = String.join("|", delimiter);

        String[] parsedNumbers = input.split(delimiterRegex);

        List<Integer> numbersList = new ArrayList<>();

        for (String numStr : parsedNumbers) {
            numbersList.add(Integer.parseInt(numStr));
        }

        return numbersList;
    }
}
